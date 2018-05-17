package io.mercadito.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.mercadito.api.bean.Usuario;
import io.mercadito.api.repo.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepo;

	public List<Usuario> findAll() {
		return usuarioRepo.findAll();
	}

	public Usuario findOne(Integer idx) {
		return usuarioRepo.findOne(idx);
	}

	public Usuario insert(Usuario usuario) {
		return usuarioRepo.save(usuario);
	}
}
