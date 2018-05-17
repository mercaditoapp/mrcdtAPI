package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Perfil;
import io.mercadito.api.repo.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	PerfilRepository perfilRepo;

	public List<Perfil> findAll() {
		return perfilRepo.findAll();
	}

	public Perfil findOne(Integer idx) {
		return perfilRepo.findOne(idx);
	}

	public Perfil insert(Perfil perfil) {
		return perfilRepo.save(perfil);
	}
}
