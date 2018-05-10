package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.PrecioBase;
import io.mercadito.api.repo.PrecioBaseRepository;

@Service
public class PrecioBaseService {

	@Autowired
	PrecioBaseRepository precioBaseRepo;

	public List<PrecioBase> findAll() {
		return precioBaseRepo.findAll();
	}

	public PrecioBase findOne(Integer idx) {
		return precioBaseRepo.findOne(idx);
	}

	public PrecioBase insert(PrecioBase precioBase) {
		return precioBaseRepo.save(precioBase);
	}
}
