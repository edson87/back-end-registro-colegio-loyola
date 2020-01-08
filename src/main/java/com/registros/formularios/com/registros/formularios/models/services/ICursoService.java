package com.registros.formularios.com.registros.formularios.models.services;


import com.registros.formularios.com.registros.formularios.models.entity.Curso;

import java.util.List;

public interface ICursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save(Curso curso);
}
