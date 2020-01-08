package com.registros.formularios.com.registros.formularios.controllers;

import com.registros.formularios.com.registros.formularios.models.entity.Curso;
import com.registros.formularios.com.registros.formularios.models.services.ICursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/cursosApi")
public class CursoController  {

    @Autowired
    private ICursoService cursoService;

    @GetMapping("/cursos")
    public List<Curso> findAll(){
        List<Curso> cursos = cursoService.findAll();
        return cursos;
    }

    @GetMapping("/cursos/{id}")
    public Curso findAllById(@PathVariable Long id){
        Curso curso = cursoService.findById(id);
        return curso;
    }
}
