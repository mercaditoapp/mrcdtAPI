package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.PrecioMinimoVenta;

@Repository
public interface PrecioMinimoVentaRepository extends JpaRepository<PrecioMinimoVenta, Integer> {

}