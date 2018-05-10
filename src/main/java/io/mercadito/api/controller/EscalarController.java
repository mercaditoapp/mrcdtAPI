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

import io.mercadito.api.bean.Escalar;
import io.mercadito.api.service.EscalarService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/escalar")
public class EscalarController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	EscalarService escalarService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Escalar> findAll() {
		return escalarService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Escalar findOne(@PathVariable Integer idx) {
		return escalarService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Escalar insert(@RequestBody Escalar escalar) {
		logger.info(escalar);

		return escalarService.insert(escalar);
	}
}
