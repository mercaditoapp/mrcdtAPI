package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.IngredienteReceta;
import io.mercadito.api.repo.IngredienteRecetaRepository;

@Service
public class IngredienteRecetaService {

	@Autowired
	IngredienteRecetaRepository ingredienteRecetaRepo;

	public List<IngredienteReceta> findAll() {

		return ingredienteRecetaRepo.findAll();
	}

	public IngredienteReceta findOne(Integer idx) {
		return ingredienteRecetaRepo.findOne(idx);
	}

	public IngredienteReceta insert(IngredienteReceta ingredienteReceta) {
		return ingredienteRecetaRepo.save(ingredienteReceta);
	}

	public void delete(IngredienteReceta ingredienteReceta) {
		ingredienteRecetaRepo.delete(ingredienteReceta);
	}

	public void deleteByRecetaIdx(Integer idx) {
		ingredienteRecetaRepo.deleteByRecetaIdx(idx);
	}

}
