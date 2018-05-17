package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Pedido;
import io.mercadito.api.repo.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepo;

	public List<Pedido> findAll() {
		return pedidoRepo.findAll();
	}

	public Pedido findOne(Integer idx) {
		return pedidoRepo.findOne(idx);
	}

	public Pedido insert(Pedido pedido) {
		return pedidoRepo.save(pedido);
	}
}
