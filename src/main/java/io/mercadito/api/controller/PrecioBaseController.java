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

import io.mercadito.api.bean.PrecioBase;
import io.mercadito.api.service.PrecioBaseService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/precioBase")
public class PrecioBaseController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	PrecioBaseService precioBaseService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<PrecioBase> findAll() {
		return precioBaseService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public PrecioBase findOne(@PathVariable Integer idx) {
		return precioBaseService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public PrecioBase insert(@RequestBody PrecioBase precioBase) {
		logger.info(precioBase);

		return precioBaseService.insert(precioBase);
	}
}
