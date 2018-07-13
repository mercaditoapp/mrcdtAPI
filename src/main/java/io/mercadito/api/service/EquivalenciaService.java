package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Equivalencia;
import io.mercadito.api.repo.EquivalenciaRepository;

@Service
public class EquivalenciaService {

	@Autowired
	EquivalenciaRepository equivalenciaRepo;

	public List<Equivalencia> findAll() {
		return equivalenciaRepo.findAll();
	}

	public Equivalencia findOne(Integer idx) {
		return equivalenciaRepo.findOne(idx);
	}

	public Equivalencia insert(Equivalencia equivalencia) {
		return equivalenciaRepo.save(equivalencia);
	}
}
