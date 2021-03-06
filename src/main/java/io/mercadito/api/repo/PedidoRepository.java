package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

}