package com.registros.formularios.com.registros.formularios.models.dao;

import com.registros.formularios.com.registros.formularios.models.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoDao extends JpaRepository<Curso, Long> {
}
