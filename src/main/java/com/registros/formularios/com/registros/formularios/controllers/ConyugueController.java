package com.registros.formularios.com.registros.formularios.controllers;


import com.registros.formularios.com.registros.formularios.models.entity.Conyugue;
import com.registros.formularios.com.registros.formularios.models.services.ConyugueServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/conyugueApi")
public class ConyugueController {

    @Autowired
    private ConyugueServiceImpl conyugueService;

    @GetMapping("/conyugues")
    public List<Conyugue> findAll(){
        List<Conyugue> lista = conyugueService.findAll();
        return lista;
    }
}
