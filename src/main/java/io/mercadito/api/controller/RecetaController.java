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

import io.mercadito.api.bean.Receta;
import io.mercadito.api.service.RecetaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/receta")
public class RecetaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	RecetaService recetaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Receta> findAll() {
		return recetaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findByNombreUrl/{nombreUrl}")
	public Receta findByNombreUrl(@PathVariable String nombreUrl) {
		return recetaService.findByNombreUrl(nombreUrl);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Receta insert(@RequestBody Receta receta) {
		logger.info(receta);

		return recetaService.insert(receta);
	}
}
