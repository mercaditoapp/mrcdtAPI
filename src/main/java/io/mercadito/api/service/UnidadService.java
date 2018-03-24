package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Unidad;
import io.mercadito.api.repo.UnidadRepository;

@Service
public class UnidadService {

	@Autowired
	UnidadRepository unidadRepo;

	public List<Unidad> findAll() {
		return unidadRepo.findAll();
	}

	public Unidad findOne(Integer idx) {
		return unidadRepo.findOne(idx);
	}

	public Unidad insert(Unidad unidad) {
		return unidadRepo.save(unidad);
	}
}
