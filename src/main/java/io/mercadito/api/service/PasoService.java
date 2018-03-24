package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Paso;
import io.mercadito.api.repo.PasoRepository;

@Service
public class PasoService {

	@Autowired
	PasoRepository pasoRepo;

	public List<Paso> findAll() {
		return pasoRepo.findAll();
	}

	public Paso findOne(Integer idx) {
		return pasoRepo.findOne(idx);
	}

	public Paso insert(Paso paso) {
		return pasoRepo.save(paso);
	}
}
