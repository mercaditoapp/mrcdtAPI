package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Escalar;
import io.mercadito.api.repo.EscalarRepository;

@Service
public class EscalarService {

	@Autowired
	EscalarRepository escalarRepo;

	public List<Escalar> findAll() {
		return escalarRepo.findAll();
	}

	public Escalar findOne(Integer idx) {
		return escalarRepo.findOne(idx);
	}

	public Escalar insert(Escalar escalar) {

		try {
			escalar = escalarRepo.save(escalar);
		} catch (Exception e) {
			Example<Escalar> example = Example.of(escalar);

			Escalar escalarExample = escalarRepo.findOne(example);

			if (escalarExample != null && escalarExample.getIdx() != null) {
				return escalarExample;
			}
		}

		return escalar;

	}
}
