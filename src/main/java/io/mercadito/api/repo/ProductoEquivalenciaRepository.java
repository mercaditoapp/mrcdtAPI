package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import io.mercadito.api.bean.ProductoEquivalencia;

public interface ProductoEquivalenciaRepository extends JpaRepository<ProductoEquivalencia, Integer> {

}