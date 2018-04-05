package io.mercadito.api.controller;

import java.util.ArrayList;
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

import io.mercadito.api.bean.IngredienteProcedimiento;
import io.mercadito.api.bean.IngredienteReceta;
import io.mercadito.api.bean.Procedimiento;
import io.mercadito.api.bean.Receta;
import io.mercadito.api.service.IngredienteRecetaService;
import io.mercadito.api.service.ProcedimientoService;
import io.mercadito.api.service.RecetaService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("oauth/receta")
public class RecetaController {

	private Logger logger = LogManager.getLogger(getClass());

	@Autowired
	RecetaService recetaService;

	@Autowired
	ProcedimientoService procedimientoService;

	@Autowired
	IngredienteRecetaService ingredienteRecetaService;

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Receta> findAll() {
		return recetaService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/findByNombreUrl/{nombreUrl}")
	public Receta findByNombreUrl(@PathVariable String nombreUrl) {
		return recetaService.findByNombreUrl(nombreUrl);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/deleteByIdx/{idx}")
	public void deleteByIdx(@PathVariable Integer idx) {
		recetaService.deleteByIdx(idx);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/actualizarIngredientes/{idx}")
	public List<IngredienteReceta> actualizarIngredientes(@PathVariable Integer idx) {
		Receta receta = recetaService.findOne(idx);

		logger.info(receta.getIdx());

		List<Procedimiento> procedimientos = procedimientoService.findByRecetaIdx(receta.getIdx());

		// List<IngredienteReceta> ingredientesReceta =
		// receta.getIngredientesReceta();
		List<IngredienteReceta> ingredientesRecetaTmp = new ArrayList<IngredienteReceta>();
		List<IngredienteReceta> ingredientesRecetaSum = new ArrayList<IngredienteReceta>();

		for (Procedimiento procedimiento : procedimientos) {
			for (IngredienteProcedimiento ingredienteProcedimiento : procedimiento.getIngredientesProcedimiento()) {

				IngredienteReceta ingredienteReceta = new IngredienteReceta();

				ingredienteReceta.setCantidad(ingredienteProcedimiento.getCantidad());
				ingredienteReceta.setProducto(ingredienteProcedimiento.getProducto());
				ingredienteReceta.setUnidad(ingredienteProcedimiento.getUnidad());
				ingredienteReceta.setReceta(receta);

				ingredientesRecetaTmp.add(ingredienteReceta);

			}
		}

		// logger.info(ingredientesRecetaTmp);

		for (IngredienteReceta ingredienteRecetaTmp : ingredientesRecetaTmp) {
			boolean found = false;

			Integer productoIdx = ingredienteRecetaTmp.getProducto().getIdx();
			Integer unidadIdx = ingredienteRecetaTmp.getUnidad().getIdx();

			for (IngredienteReceta ingredienteRecetaSum : ingredientesRecetaSum) {
				if (ingredienteRecetaSum.getProducto().getIdx().equals(productoIdx)
						&& ingredienteRecetaSum.getUnidad().getIdx().equals(unidadIdx)) {
					ingredienteRecetaSum
							.setCantidad(ingredienteRecetaSum.getCantidad() + ingredienteRecetaTmp.getCantidad());
					found = true;
				}
			}

			if (!found) {
				ingredientesRecetaSum.add(ingredienteRecetaTmp);
			}

		}

		// logger.info(ingredientesRecetaSum);

		// for (IngredienteReceta ingredienteReceta : ingredientesReceta) {
		// ingredienteRecetaService.delete(ingredienteReceta);
		// }

		ingredienteRecetaService.deleteByRecetaIdx(receta.getIdx());

		for (IngredienteReceta ingredienteReceta : ingredientesRecetaSum) {
			ingredienteRecetaService.insert(ingredienteReceta);
		}

		return ingredientesRecetaSum;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Receta insert(@RequestBody Receta receta) {
		logger.info(receta);

		return recetaService.insert(receta);
	}
}
