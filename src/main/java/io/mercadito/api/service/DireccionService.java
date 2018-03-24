package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Direccion;
import io.mercadito.api.repo.DireccionRepository;

@Service
public class DireccionService {

	@Autowired
	DireccionRepository direccionRepo;

	public List<Direccion> findAll() {
		return direccionRepo.findAll();
	}

	public Direccion findOne(Integer idx) {
		return direccionRepo.findOne(idx);
	}

	public Direccion insert(Direccion direccion) {
		return direccionRepo.save(direccion);
	}
}
