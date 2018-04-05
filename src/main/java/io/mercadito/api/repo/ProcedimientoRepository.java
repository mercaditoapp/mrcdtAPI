package io.mercadito.api.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Procedimiento;

@Repository
public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Integer> {

	@Query("from Procedimiento where receta.idx = :recetaIdx")
	List<Procedimiento> findByRecetaIdx(@Param("recetaIdx") Integer recetaIdx);

}
