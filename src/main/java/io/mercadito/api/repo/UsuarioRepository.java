package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}