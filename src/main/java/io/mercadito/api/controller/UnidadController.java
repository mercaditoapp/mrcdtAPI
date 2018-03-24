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

import io.mercadito.api.bean.Unidad;
import io.mercadito.api.service.UnidadService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/unidad")
public class UnidadController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	UnidadService unidadService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Unidad> findAll() {
		return unidadService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Unidad findOne(@PathVariable Integer idx) {
		return unidadService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Unidad insert(@RequestBody Unidad unidad) {
		logger.info(unidad);

		return unidadService.insert(unidad);
	}
}
