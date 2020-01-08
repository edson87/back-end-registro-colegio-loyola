package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.entity.Estudiante;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {

    public List<Estudiante> findAll();
    public Page<Estudiante> findAll(Pageable page);

    public Estudiante create(Estudiante estudiante);
    public Estudiante findEstudianteByCelulaId(int ci);
    public Estudiante findById(Long id);

    public void remove(Long id);
    /*public List<Estudiante>findByNombreStartingWith(String nombre);*/
}
