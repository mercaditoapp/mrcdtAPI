package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Unidad;

@Repository
public interface UnidadRepository extends JpaRepository<Unidad, Integer> {

}