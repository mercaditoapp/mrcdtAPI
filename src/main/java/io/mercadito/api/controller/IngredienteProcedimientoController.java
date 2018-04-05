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

import io.mercadito.api.bean.IngredienteProcedimiento;
import io.mercadito.api.service.IngredienteProcedimientoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/ingrediente_procedimiento")
public class IngredienteProcedimientoController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	IngredienteProcedimientoService ingredienteProcedimientoService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<IngredienteProcedimiento> findAll() {
		return ingredienteProcedimientoService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public IngredienteProcedimiento findOne(@PathVariable Integer idx) {
		return ingredienteProcedimientoService.findOne(idx);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteByIdx/{idx}")
	public void deleteByIdx(@PathVariable Integer idx) {
		ingredienteProcedimientoService.deleteByIdx(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public IngredienteProcedimiento insert(@RequestBody IngredienteProcedimiento ingredienteProcedimiento) {
		logger.info(ingredienteProcedimiento);

		return ingredienteProcedimientoService.insert(ingredienteProcedimiento);
	}
}
