package com.registros.formularios.com.registros.formularios.controllers;

import com.registros.formularios.com.registros.formularios.models.entity.Profesor;
import com.registros.formularios.com.registros.formularios.models.services.IProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/profesorApi")
public class ProfesorController  {
    @Autowired
    private IProfesorService profesorService;

    @GetMapping("/profesores")
    @ResponseStatus(HttpStatus.OK)
    public List<Profesor> findAll(){
        List<Profesor> lista = profesorService.findAll();
        return lista;
    }
}
