package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.PrecioMinimoVenta;
import io.mercadito.api.repo.PrecioMinimoVentaRepository;

@Service
public class PrecioMinimoVentaService {

	@Autowired
	PrecioMinimoVentaRepository precioMinimoVentaRepo;

	public List<PrecioMinimoVenta> findAll() {
		return precioMinimoVentaRepo.findAll();
	}

	public PrecioMinimoVenta findOne(Integer idx) {
		return precioMinimoVentaRepo.findOne(idx);
	}

	public PrecioMinimoVenta insert(PrecioMinimoVenta precioMinimoVenta) {
		return precioMinimoVentaRepo.save(precioMinimoVenta);
	}
}
