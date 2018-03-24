package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.IngredienteProcedimiento;
import io.mercadito.api.repo.IngredienteProcedimientoRepository;

@Service
public class IngredienteProcedimientoService {

	@Autowired
	IngredienteProcedimientoRepository ingredientePreocedimientoRepo;

	public List<IngredienteProcedimiento> findAll() {
		return ingredientePreocedimientoRepo.findAll();
	}

	public IngredienteProcedimiento findOne(Integer idx) {
		return ingredientePreocedimientoRepo.findOne(idx);
	}

	public IngredienteProcedimiento insert(IngredienteProcedimiento ingredienteProcedimiento) {
		return ingredientePreocedimientoRepo.save(ingredienteProcedimiento);
	}
}
