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

import io.mercadito.api.bean.Pedido;
import io.mercadito.api.service.PedidoService;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("oauth/pedido")
public class PedidoController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	PedidoService pedidoService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Pedido> findAll() {
		return pedidoService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findOne/{idx}")
	public Pedido findOne(@PathVariable Integer idx) {
		return pedidoService.findOne(idx);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Pedido insert(@RequestBody Pedido pedido) {
		logger.info(pedido);

		return pedidoService.insert(pedido);
	}
}
