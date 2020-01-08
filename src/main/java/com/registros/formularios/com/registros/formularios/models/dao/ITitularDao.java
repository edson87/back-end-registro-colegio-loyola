package com.registros.formularios.com.registros.formularios.models.dao;

import com.registros.formularios.com.registros.formularios.models.entity.Titular;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITitularDao extends JpaRepository<Titular,Long> {
        public Titular findAllById(Long id);
        public Titular findByCodigotitular(int codTitular);
}
