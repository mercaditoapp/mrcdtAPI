package io.mercadito.api.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.mercadito.api.bean.Producto;
import io.mercadito.api.service.ProductoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/producto")
public class ProductoController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	ProductoService productoService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Producto> findAll() {
		return productoService.findAll();
	}

	@RequestMapping(value = "/findByNombre", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Producto> findByNombre(@RequestBody Producto producto) {
		logger.info(producto);

		return productoService.findByNombre(producto.getNombre());
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Producto insert(@RequestBody Producto producto) {
		logger.info(producto);

		return productoService.insert(producto);
	}
}
