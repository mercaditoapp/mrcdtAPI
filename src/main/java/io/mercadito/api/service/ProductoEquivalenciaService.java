package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

	public ProductoEquivalencia insert(ProductoEquivalencia productoEquivalencia) {

		try {
			productoEquivalencia = productoEquivalenciaRepo.save(productoEquivalencia);
		} catch (Exception e) {
			Example<ProductoEquivalencia> example = Example.of(productoEquivalencia);

			ProductoEquivalencia productoEquivalenciaExample = productoEquivalenciaRepo.findOne(example);

			if (productoEquivalenciaExample != null && productoEquivalenciaExample.getIdx() != null) {
				return productoEquivalenciaExample;
			}
		}

		return productoEquivalencia;

	}
}
