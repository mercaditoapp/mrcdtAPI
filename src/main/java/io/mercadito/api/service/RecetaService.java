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

	public Receta findByNombreUrl(String nombreUrl) {
		return recetaRepo.findByNombreUrl(nombreUrl);
	}

	public Receta insert(Receta receta) {
		return recetaRepo.save(receta);
	}
}
