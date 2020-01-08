package com.registros.formularios.com.registros.formularios.models.dao;


import com.registros.formularios.com.registros.formularios.models.entity.Estudiante;
import com.registros.formularios.com.registros.formularios.models.entity.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEstudianteDao extends JpaRepository<Estudiante,Long> {

    public Estudiante findEstudianteByCelulaId(int ci);
    /*List<Estudiante> findByNombreStartingWith(String nombre);*/
}
