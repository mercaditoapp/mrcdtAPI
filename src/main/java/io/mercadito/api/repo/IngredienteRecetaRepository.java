package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.IngredienteReceta;

@Repository
public interface IngredienteRecetaRepository extends JpaRepository<IngredienteReceta, Integer> {

}