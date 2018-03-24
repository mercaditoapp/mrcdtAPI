package io.mercadito.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Integer> {

	@Query("from Producto where nombre like %:nombre%")
	List<Producto> findByNombre(@Param("nombre") String nombre);

}