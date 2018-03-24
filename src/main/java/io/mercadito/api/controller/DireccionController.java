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

import io.mercadito.api.bean.Direccion;
import io.mercadito.api.service.DireccionService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/direccion")
public class DireccionController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	DireccionService direccionService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Direccion> findAll() {
		return direccionService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Direccion findOne(@PathVariable Integer idx) {
		return direccionService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Direccion insert(@RequestBody Direccion direccion) {
		logger.info(direccion);

		return direccionService.insert(direccion);
	}
}
