package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Paso;

@Repository
public interface PasoRepository extends JpaRepository<Paso, Integer> {

}