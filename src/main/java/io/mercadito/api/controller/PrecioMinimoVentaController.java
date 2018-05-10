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

import io.mercadito.api.bean.PrecioMinimoVenta;
import io.mercadito.api.service.PrecioMinimoVentaService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/precioMinimoVenta")
public class PrecioMinimoVentaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	PrecioMinimoVentaService precioMinimoVentaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<PrecioMinimoVenta> findAll() {
		return precioMinimoVentaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public PrecioMinimoVenta findOne(@PathVariable Integer idx) {
		return precioMinimoVentaService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PrecioMinimoVenta insert(@RequestBody PrecioMinimoVenta precioMinimoVenta) {
		logger.info(precioMinimoVenta);

		return precioMinimoVentaService.insert(precioMinimoVenta);
	}
}
