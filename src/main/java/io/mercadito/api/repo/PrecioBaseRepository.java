package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.PrecioBase;

@Repository
public interface PrecioBaseRepository extends JpaRepository<PrecioBase, Integer> {

}