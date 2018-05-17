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

import io.mercadito.api.bean.Perfil;
import io.mercadito.api.service.PerfilService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/perfil")
public class PerfilController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	PerfilService perfilService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Perfil> findAll() {
		return perfilService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Perfil findOne(@PathVariable Integer idx) {
		return perfilService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Perfil insert(@RequestBody Perfil perfil) {
		logger.info(perfil);

		return perfilService.insert(perfil);
	}
}
