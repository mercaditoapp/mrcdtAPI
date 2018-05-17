package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer> {

}