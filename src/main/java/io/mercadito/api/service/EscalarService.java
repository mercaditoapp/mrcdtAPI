package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Escalar;
import io.mercadito.api.repo.EscalarRepository;

@Service
public class EscalarService {

	@Autowired
	EscalarRepository escalarRepo;

	public List<Escalar> findAll() {
		return escalarRepo.findAll();
	}

	public Escalar findOne(Integer idx) {
		return escalarRepo.findOne(idx);
	}

	public Escalar insert(Escalar escalar) {
		return escalarRepo.save(escalar);
	}
}
