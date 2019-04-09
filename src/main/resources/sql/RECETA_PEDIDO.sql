DROP PROCEDURE IF EXISTS RECETA_PEDIDO;

DELIMITER $$

CREATE PROCEDURE RECETA_PEDIDO(IN RECETA_IDX INTEGER(255))
BEGIN
  DECLARE done INT DEFAULT FALSE;

  DECLARE NOMBRE_RECETA VARCHAR(45);
  DECLARE NOMBRE_PRODUCTO VARCHAR(45);
  DECLARE C_PRODUCTO_RECETA VARCHAR(45);
  DECLARE U_PRODUCTO_RECETA VARCHAR(45);
  DECLARE C_PRODUCTO_PRESENTACION VARCHAR(45);
  DECLARE U_PRODUCTO_PRESENTACION VARCHAR(45);
  DECLARE C_PRODUCTO_CONTENIDO VARCHAR(45);
  DECLARE U_PRODUCTO_CONTENIDO VARCHAR(45);

DECLARE CANTIDAD_PRODUCTO_RELACION FLOAT;
DECLARE CANTIDAD_PRODUCTO_PRESENTACION FLOAT;

DECLARE CANTIDAD_PRODUCTO_EQUIVALENCIA FLOAT;

DECLARE RECETA_PRODUCTO CURSOR FOR SELECT
	R.NOMBRE NOMBRE_RECETA,
	P.NOMBRE NOMBRE_PRODUCTO,
	IR.CANTIDAD C_PRODUCTO_RECETA,
	IR_U.NOMBRE U_PRODUCTO_RECETA,
	ESC_P.VALOR C_PRODUCTO_PRESENTACION,
	U_P.NOMBRE U_PRODUCTO_PRESENTACION,
	ESC_C.VALOR C_PRODUCTO_CONTENIDO,
	U_C.NOMBRE U_PRODUCTO_CONTENIDO 
FROM RECETA R
INNER JOIN INGREDIENTE_RECETA IR ON (R.IDX = IR.RECETA_IDX)
INNER JOIN UNIDAD IR_U ON (IR.UNIDAD_IDX = IR_U.IDX)
INNER JOIN PRODUCTO P ON (P.IDX = IR.PRODUCTO_IDX)
INNER JOIN PRECIO_MINIMO_VENTA PMV ON (P.IDX = PMV.PRODUCTO_IDX AND PMV.ALMACEN_IDX = 1)
INNER JOIN ESCALAR ESC_C ON (PMV.ESCALAR_CONTENIDO_IDX = ESC_C.IDX)
INNER JOIN UNIDAD U_C ON (ESC_C.UNIDAD_IDX = U_C.IDX)
INNER JOIN ESCALAR ESC_P ON (PMV.ESCALAR_PRESENTACION_IDX = ESC_P.IDX)
INNER JOIN UNIDAD U_P ON (ESC_P.UNIDAD_IDX = U_P.IDX)
WHERE R.IDX = RECETA_IDX
ORDER BY P.IDX;

  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

  OPEN RECETA_PRODUCTO;

  read_loop: LOOP
    FETCH RECETA_PRODUCTO INTO NOMBRE_RECETA, NOMBRE_PRODUCTO, C_PRODUCTO_RECETA,U_PRODUCTO_RECETA,C_PRODUCTO_PRESENTACION,U_PRODUCTO_PRESENTACION,C_PRODUCTO_CONTENIDO,U_PRODUCTO_CONTENIDO;

    IF done THEN
      LEAVE read_loop;
    END IF;

    IF U_PRODUCTO_RECETA = U_PRODUCTO_CONTENIDO THEN 
        INSERT INTO LOG (TEXTO) VALUES (CONCAT(NOMBRE_PRODUCTO, " UNIDADES DE RECETA = UNIDADES DE CONTENIDO"));
        INSERT INTO LOG (TEXTO) VALUES (CONCAT(C_PRODUCTO_RECETA/C_PRODUCTO_CONTENIDO, " RELACIÓN [RECETA UNIDADES/UNIDADES CONTENIDO PRODUCTO]"));
        
        SET CANTIDAD_PRODUCTO_RELACION = CEILING(C_PRODUCTO_RECETA/C_PRODUCTO_CONTENIDO);
        
        INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_RELACION, " TECHO DE LA RELACION"));

        SET CANTIDAD_PRODUCTO_PRESENTACION = CANTIDAD_PRODUCTO_RELACION * C_PRODUCTO_PRESENTACION;

        INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_PRESENTACION, " ", U_PRODUCTO_PRESENTACION));
    ELSE
        INSERT INTO LOG (TEXTO) VALUES (CONCAT(NOMBRE_PRODUCTO, " UNIDADES DE RECETA != UNIDADES DE CONTENIDO"));
        
        IF U_PRODUCTO_RECETA = U_PRODUCTO_PRESENTACION THEN
            INSERT INTO LOG (TEXTO) VALUES (CONCAT(NOMBRE_PRODUCTO, " UNIDADES DE RECETA == UNIDADES DE PRESENTACIÓN"));

            INSERT INTO LOG (TEXTO) VALUES (CONCAT(C_PRODUCTO_RECETA/C_PRODUCTO_PRESENTACION, " RELACIÓN [RECETA UNIDADES/UNIDADES PRESENTACIÓN PRODUCTO]"));

            SET CANTIDAD_PRODUCTO_RELACION = CEILING(C_PRODUCTO_RECETA/C_PRODUCTO_PRESENTACION);

            INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_RELACION, " TECHO DE LA RELACION"));

            SET CANTIDAD_PRODUCTO_PRESENTACION = CANTIDAD_PRODUCTO_RELACION * C_PRODUCTO_PRESENTACION;

            INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_PRESENTACION, " ", U_PRODUCTO_PRESENTACION));
        ELSE
            INSERT INTO LOG (TEXTO) VALUES (CONCAT(NOMBRE_PRODUCTO, " UNIDADES DE RECETA != UNIDADES DE PRESENTACIÓN != UNIDADES DE CONTENIDO"));
        BLOCK2: BEGIN
              DECLARE done_equivalencia INT DEFAULT FALSE;

              DECLARE NOMBRE_PRODUCTO_EQUIVALENCIA VARCHAR(45);
              DECLARE A_CANTIDAD VARCHAR(45);
              DECLARE A_UNIDAD VARCHAR(45);
              DECLARE B_CANTIDAD VARCHAR(45);
              DECLARE B_UNIDAD VARCHAR(45);

              DECLARE EQUIVALENCIA_PRODUCTO CURSOR FOR SELECT 
                    P.NOMBRE NOMBRE_PRODUCTO_EQUIVALENCIA, 
                    ESC_A.VALOR A_CANTIDAD, 
                    U_A.NOMBRE A_UNIDAD, 
                    ESC_B.VALOR B_CANTIDAD, 
                    U_B.NOMBRE B_UNIDAD
                FROM PRODUCTO P
                INNER JOIN PRODUCTO_EQUIVALENCIA PE ON (P.IDX = PE.PRODUCTO_IDX)
                INNER JOIN EQUIVALENCIA E ON (E.IDX = PE.EQUIVALENCIA_IDX)
                INNER JOIN ESCALAR ESC_A ON (E.ESCALAR_A_IDX = ESC_A.IDX)
                INNER JOIN ESCALAR ESC_B ON (E.ESCALAR_B_IDX = ESC_B.IDX)
                INNER JOIN UNIDAD U_A ON (ESC_A.UNIDAD_IDX = U_A.IDX)
                INNER JOIN UNIDAD U_B ON (ESC_B.UNIDAD_IDX = U_B.IDX)
                WHERE U_A.NOMBRE = U_PRODUCTO_RECETA;

                DECLARE CONTINUE HANDLER FOR NOT FOUND SET done_equivalencia = TRUE;

                OPEN EQUIVALENCIA_PRODUCTO;

                  equivalencia_loop: LOOP
                    FETCH EQUIVALENCIA_PRODUCTO INTO NOMBRE_PRODUCTO_EQUIVALENCIA, A_CANTIDAD, A_UNIDAD,B_CANTIDAD,B_UNIDAD;

                    IF done_equivalencia THEN
                      LEAVE equivalencia_loop;
                    END IF;

                    INSERT INTO LOG (TEXTO) VALUES (CONCAT("BLOQUE 2: ", NOMBRE_PRODUCTO_EQUIVALENCIA, " ", A_UNIDAD));

                    SET CANTIDAD_PRODUCTO_EQUIVALENCIA = C_PRODUCTO_RECETA * B_CANTIDAD;

                    INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_EQUIVALENCIA/C_PRODUCTO_CONTENIDO, " RELACIÓN [CANTIDAD_PRODUCTO_EQUIVALENCIA/UNIDADES CONTENIDO PRODUCTO]"));
        
                    SET CANTIDAD_PRODUCTO_RELACION = CEILING(CANTIDAD_PRODUCTO_EQUIVALENCIA/C_PRODUCTO_CONTENIDO);
                    
                    INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_RELACION, " TECHO DE LA RELACION"));

                    SET CANTIDAD_PRODUCTO_PRESENTACION = CANTIDAD_PRODUCTO_RELACION * C_PRODUCTO_PRESENTACION;

                    INSERT INTO LOG (TEXTO) VALUES (CONCAT(CANTIDAD_PRODUCTO_PRESENTACION, " ", U_PRODUCTO_PRESENTACION));               
                  END LOOP;

                CLOSE EQUIVALENCIA_PRODUCTO;
        END BLOCK2;
        END IF;


    END IF;

    ##INSERT INTO ALMACEN_COPY (NOMBRE) VALUE(NOMBRE_PRODUCTO);

  END LOOP;

  CLOSE RECETA_PRODUCTO;

END$$

DELIMITER ;