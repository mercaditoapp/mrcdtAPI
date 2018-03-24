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

import io.mercadito.api.bean.Procedimiento;
import io.mercadito.api.service.ProcedimientoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/procedimiento")
public class ProcedimientoController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	ProcedimientoService procedimientoService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Procedimiento> findAll() {
		return procedimientoService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Procedimiento findOne(@PathVariable Integer idx) {
		return procedimientoService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Procedimiento insert(@RequestBody Procedimiento procedimiento) {
		logger.info(procedimiento);

		return procedimientoService.insert(procedimiento);
	}
}
