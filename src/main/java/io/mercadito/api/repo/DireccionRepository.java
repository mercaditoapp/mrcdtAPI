package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Direccion;

@Repository
public interface DireccionRepository extends JpaRepository<Direccion, Integer> {

}