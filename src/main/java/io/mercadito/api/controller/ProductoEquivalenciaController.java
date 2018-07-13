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

import io.mercadito.api.bean.ProductoEquivalencia;
import io.mercadito.api.service.ProductoEquivalenciaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/productoEquivalencia")
public class ProductoEquivalenciaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	ProductoEquivalenciaService productoEquivalenciaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<ProductoEquivalencia> findAll() {
		return productoEquivalenciaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public ProductoEquivalencia findOne(@PathVariable Integer idx) {
		return productoEquivalenciaService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductoEquivalencia insert(@RequestBody ProductoEquivalencia productoEquivalencia) {
		logger.info(productoEquivalencia);

		return productoEquivalenciaService.insert(productoEquivalencia);
	}
}
