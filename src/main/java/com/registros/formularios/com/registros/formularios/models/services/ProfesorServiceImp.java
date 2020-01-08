package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.IProfesorDao;
import com.registros.formularios.com.registros.formularios.models.entity.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfesorServiceImp implements IProfesorService {

    @Autowired
    private IProfesorDao profesorDao;

    @Override
    @Transactional(readOnly = true)
    public List<Profesor> findAll() {
        List<Profesor> lista = profesorDao.findAll();
        return  lista;
    }
}
