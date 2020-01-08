package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.IEstudianteDao;
import com.registros.formularios.com.registros.formularios.models.entity.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteServiceImp implements IEstudianteService {
    @Autowired
    private IEstudianteDao estudianteDao;


    @Override
    @Transactional(readOnly = true)
    public List<Estudiante> findAll() {
        return estudianteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Estudiante> findAll(Pageable page) {
        return estudianteDao.findAll(page);
    }

    @Override
    public Estudiante create(Estudiante estudiante) {
        return estudianteDao.save(estudiante);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findEstudianteByCelulaId(int ci) {
        return estudianteDao.findEstudianteByCelulaId(ci);
    }

    @Override
    @Transactional(readOnly = true)
    public Estudiante findById(Long id) {
        return estudianteDao.findById(id).get();
    }

    @Override
    public void remove(Long id) {
        estudianteDao.deleteById(id);
    }

}
