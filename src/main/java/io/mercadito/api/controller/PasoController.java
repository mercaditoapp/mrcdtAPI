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

import io.mercadito.api.bean.Paso;
import io.mercadito.api.service.PasoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/paso")
public class PasoController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	PasoService pasoService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Paso> findAll() {
		return pasoService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Paso findOne(@PathVariable Integer idx) {
		return pasoService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Paso insert(@RequestBody Paso paso) {
		logger.info(paso);

		return pasoService.insert(paso);
	}
}
