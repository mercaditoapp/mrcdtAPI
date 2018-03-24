package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Receta;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {

	@Query("from Receta where nombreUrl=:nombreUrl")
	Receta findByNombreUrl(@Param("nombreUrl") String nombreUrl);
}