package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Producto;
import io.mercadito.api.repo.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	ProductoRepository productoRepo;

	public List<Producto> findAll() {
		return productoRepo.findAll();
	}

	public List<Producto> findByNombre(String nombre) {
		return productoRepo.findByNombre(nombre);
	}

	public Producto findOne(Integer idx) {
		return productoRepo.findOne(idx);
	}

	public Producto insert(Producto producto) {
		return productoRepo.save(producto);
	}
}
