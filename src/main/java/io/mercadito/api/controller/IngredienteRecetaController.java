package io.mercadito.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mercadito.api.bean.IngredienteReceta;
import io.mercadito.api.service.IngredienteRecetaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/ingrediente_receta")
public class IngredienteRecetaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	IngredienteRecetaService ingredienteRecetaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<IngredienteReceta> findAll() {
		return ingredienteRecetaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public IngredienteReceta findOne(@PathVariable Integer idx) {
		return ingredienteRecetaService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public IngredienteReceta insert(@RequestBody IngredienteReceta ingredienteProcedimiento) {
		logger.info(ingredienteProcedimiento);

		return ingredienteRecetaService.insert(ingredienteProcedimiento);
	}
}
