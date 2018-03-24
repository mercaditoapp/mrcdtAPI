package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.IngredienteProcedimiento;

@Repository
public interface IngredienteProcedimientoRepository extends JpaRepository<IngredienteProcedimiento, Integer> {

}