package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import io.mercadito.api.bean.IngredienteReceta;

@Repository
public interface IngredienteRecetaRepository extends JpaRepository<IngredienteReceta, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM IngredienteReceta WHERE receta.idx = :recetaIdx")
	void deleteByRecetaIdx(@Param("recetaIdx") Integer recetaIdx);

}