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

import io.mercadito.api.bean.Equivalencia;
import io.mercadito.api.service.EquivalenciaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/equivalencia")
public class EquivalenciaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	EquivalenciaService equivalenciaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Equivalencia> findAll() {
		return equivalenciaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Equivalencia findOne(@PathVariable Integer idx) {
		return equivalenciaService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Equivalencia insert(@RequestBody Equivalencia equivalencia) {
		logger.info(equivalencia);

		return equivalenciaService.insert(equivalencia);
	}
}
