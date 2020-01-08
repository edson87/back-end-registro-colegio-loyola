package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.ITitularDao;
import com.registros.formularios.com.registros.formularios.models.entity.Titular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TitularServiceImpl implements ITitularService {
    @Autowired
    private ITitularDao titularDao;

    @Override
    @Transactional(readOnly = true)
    public List<Titular> findAll() {
        List<Titular> lista = titularDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Titular> findAll(Pageable page) {
        return titularDao.findAll(page);
    }

    @Override
    public Titular insertTitular(Titular titular) {
        return titularDao.save(titular);
    }

    @Override
    @Transactional(readOnly = true)
    public Titular findAllById(Long id) {
        Titular titular = titularDao.findAllById(id);
        return titular;
    }

    @Override
    public void eliminarTitular(Long id) {
        titularDao.deleteById(id);
    }

    @Override
    public Titular findByCodigotitular(int codTitular) {
        Titular titular = titularDao.findByCodigotitular(codTitular);
        return titular;
    }


}
