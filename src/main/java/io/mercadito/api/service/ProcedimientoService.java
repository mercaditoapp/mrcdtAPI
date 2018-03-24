package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Procedimiento;
import io.mercadito.api.repo.ProcedimientoRepository;

@Service
public class ProcedimientoService {

	@Autowired
	ProcedimientoRepository preocedimientoRepo;

	public List<Procedimiento> findAll() {
		return preocedimientoRepo.findAll();
	}

	public Procedimiento findOne(Integer idx) {
		return preocedimientoRepo.findOne(idx);
	}

	public Procedimiento insert(Procedimiento procedimiento) {
		return preocedimientoRepo.save(procedimiento);
	}
}
