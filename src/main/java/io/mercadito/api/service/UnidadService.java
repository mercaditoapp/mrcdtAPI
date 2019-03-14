package io.mercadito.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Producto;
import io.mercadito.api.bean.ProductoEquivalencia;
import io.mercadito.api.bean.Unidad;
import io.mercadito.api.repo.UnidadRepository;

@Service
public class UnidadService {

	@Autowired
	UnidadRepository unidadRepo;

	@Autowired
	ProductoService productoService;

	public List<Unidad> findAll() {
		return unidadRepo.findAll();
	}

	public Unidad findOne(Integer idx) {
		return unidadRepo.findOne(idx);
	}

	public Unidad insert(Unidad unidad) {
		return unidadRepo.save(unidad);
	}

	public List<Unidad> findByProductoIdx(Integer idx) {
		Producto producto = productoService.findOne(idx);

		List<Unidad> unidadesProducto = new ArrayList<>();

		unidadesProducto.add(producto.getPrecioMinimoVenta().get(0).getEscalarPresentacion().getUnidad());

		if (!producto.getPrecioMinimoVenta().get(0).getEscalarPresentacion().getUnidad().getIdx()
				.equals(producto.getPrecioMinimoVenta().get(0).getEscalarContenido().getUnidad().getIdx())) {
			unidadesProducto.add(producto.getPrecioMinimoVenta().get(0).getEscalarContenido().getUnidad());
		}

		for (ProductoEquivalencia productoEquivalencia : producto.getProductoEquivalencia()) {
			boolean addUnidad = true;

			for (Unidad unidad : unidadesProducto) {

				if (unidad.getIdx().equals(productoEquivalencia.getEquivalencia().getEscalarA().getUnidad().getIdx())) {
					addUnidad = false;
				}
			}

			if (addUnidad) {
				unidadesProducto.add(productoEquivalencia.getEquivalencia().getEscalarA().getUnidad());
			}
		}

		return unidadesProducto;
	}
}
