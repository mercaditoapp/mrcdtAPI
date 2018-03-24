package io.mercadito.api.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.mercadito.api.bean.Procedimiento;

@Repository
public interface ProcedimientoRepository extends JpaRepository<Procedimiento, Integer> {

}
