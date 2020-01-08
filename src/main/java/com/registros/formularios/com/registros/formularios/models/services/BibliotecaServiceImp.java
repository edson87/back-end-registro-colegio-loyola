package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.IBibliotecaDao;
import com.registros.formularios.com.registros.formularios.models.entity.Biblioteca;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BibliotecaServiceImp implements IBibliotecaService {
    @Autowired
    private IBibliotecaDao bibliotecaDao;


    @Override
    @Transactional(readOnly = true)
    public Biblioteca finById(Long id) {
        return bibliotecaDao.findById(id).orElse(null);
    }

    @Override
    public List<Biblioteca> findAll() {
        return bibliotecaDao.findAll();
    }

    @Override
    public Biblioteca save(Biblioteca biblioteca) {
        return bibliotecaDao.save(biblioteca);
    }

    @Override
    public void delete(Long id) {
        bibliotecaDao.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Biblioteca findAllByFechaEntregaIsNull() {
        return bibliotecaDao.findAllByFechaEntregaIsNull();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Biblioteca> findByTituloStartingWith(String titulo) {
        return bibliotecaDao.findByTituloStartingWith(titulo);
    }

}
