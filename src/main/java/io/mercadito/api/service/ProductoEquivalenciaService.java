package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.ProductoEquivalencia;
import io.mercadito.api.repo.ProductoEquivalenciaRepository;

@Service
public class ProductoEquivalenciaService {

	@Autowired
	ProductoEquivalenciaRepository productoEquivalenciaRepo;

	public List<ProductoEquivalencia> findAll() {
		return productoEquivalenciaRepo.findAll();
	}

	public ProductoEquivalencia findOne(Integer idx) {
		return productoEquivalenciaRepo.findOne(idx);
	}

	public ProductoEquivalencia insert(ProductoEquivalencia equivalencia) {
		return productoEquivalenciaRepo.save(equivalencia);
	}
}
