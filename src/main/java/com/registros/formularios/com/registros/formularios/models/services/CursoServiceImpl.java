package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.ICursoDao;
import com.registros.formularios.com.registros.formularios.models.entity.Curso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoServiceImpl implements ICursoService {
    @Autowired
    private ICursoDao cursoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Curso> findAll() {
        return cursoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Curso findById(Long id) {
        return cursoDao.findById(id).get();
    }

    @Override
    public Curso save(Curso curso) {
        return cursoDao.save(curso);
    }
}
