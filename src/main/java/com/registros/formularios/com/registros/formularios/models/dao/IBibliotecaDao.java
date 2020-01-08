package com.registros.formularios.com.registros.formularios.models.dao;

import com.registros.formularios.com.registros.formularios.models.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IBibliotecaDao extends JpaRepository<Biblioteca,Long> {

    public Biblioteca findAllByFechaEntregaIsNull();
    List<Biblioteca> findByTituloStartingWith(String titulo);
}
