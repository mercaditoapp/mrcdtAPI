package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Receta;
import io.mercadito.api.repo.RecetaRepository;

@Service
public class RecetaService {

	@Autowired
	RecetaRepository recetaRepo;

	public List<Receta> findAll() {
		return recetaRepo.findAll();
	}

	public Receta findOne(Integer idx) {
		return recetaRepo.findOne(idx);
	}

	public Receta findByNombreUrl(String nombreUrl) {
		return recetaRepo.findByNombreUrl(nombreUrl);
	}

	public void deleteByIdx(Integer idx) {
		recetaRepo.delete(idx);
	}

	public Receta insert(Receta receta) {
		return recetaRepo.save(receta);
	}
}
