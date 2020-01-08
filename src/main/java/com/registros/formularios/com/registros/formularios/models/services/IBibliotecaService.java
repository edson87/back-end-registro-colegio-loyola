package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.entity.Biblioteca;

import java.util.List;

public interface IBibliotecaService {
     Biblioteca finById(Long id);
     List<Biblioteca> findAll();
     Biblioteca save(Biblioteca biblioteca);
     void delete(Long id);
     public Biblioteca findAllByFechaEntregaIsNull();
     List<Biblioteca> findByTituloStartingWith(String titulo);
}
