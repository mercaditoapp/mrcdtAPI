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

import io.mercadito.api.bean.Usuario;
import io.mercadito.api.service.UsuarioService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/usuario")
public class UsuarioController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Usuario> findAll() {
		return usuarioService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Usuario findOne(@PathVariable Integer idx) {
		return usuarioService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Usuario insert(@RequestBody Usuario usuario) {
		logger.info(usuario);

		return usuarioService.insert(usuario);
	}
}
