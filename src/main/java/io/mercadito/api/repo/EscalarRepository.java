package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Escalar;

@Repository
public interface EscalarRepository extends JpaRepository<Escalar, Integer> {

}