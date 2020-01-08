package com.registros.formularios.com.registros.formularios.models.services;

import com.registros.formularios.com.registros.formularios.models.dao.ITitularDao;
import com.registros.formularios.com.registros.formularios.models.entity.Titular;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITitularService {

    public List<Titular> findAll();
    public Page<Titular> findAll(Pageable page);
    //INSERTAR Y ACTUALIZAR
    public Titular insertTitular(Titular titular);
    public Titular findAllById(Long id);
    public void eliminarTitular(Long id);
    public Titular findByCodigotitular(int codTitular);
}
