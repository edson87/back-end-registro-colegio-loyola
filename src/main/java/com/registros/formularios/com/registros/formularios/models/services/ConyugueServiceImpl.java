package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.IConyugueDao;
import com.registros.formularios.com.registros.formularios.models.entity.Conyugue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ConyugueServiceImpl implements IConyugueService {
    @Autowired
    private IConyugueDao conyugueDao;

    @Override
    @Transactional(readOnly = true)
    public List<Conyugue> findAll() {
        return conyugueDao.findAll();
    }
}
