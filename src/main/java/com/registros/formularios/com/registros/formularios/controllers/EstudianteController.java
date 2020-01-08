package com.registros.formularios.com.registros.formularios.controllers;

import com.registros.formularios.com.registros.formularios.models.entity.Biblioteca;
import com.registros.formularios.com.registros.formularios.models.entity.Conyugue;
import com.registros.formularios.com.registros.formularios.models.entity.Estudiante;
import com.registros.formularios.com.registros.formularios.models.entity.Titular;
import com.registros.formularios.com.registros.formularios.models.services.IEstudianteService;
import com.registros.formularios.com.registros.formularios.models.services.ITitularService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EstudianteController  {
    @Autowired
    private IEstudianteService estudianteService;
    private final Logger log = LoggerFactory.getLogger(EstudianteController.class);
    @Autowired
    private ITitularService titularService;

    @Secured("ROLE_ADMIN")
    @GetMapping("/estudiantes")
    @ResponseStatus(HttpStatus.OK)
    public List<Estudiante> index(){
        List<Estudiante> list = estudianteService.findAll();
        return list;
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/estudiantes/page/{page}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Estudiante> index(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return estudianteService.findAll(pageable);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/estudiantes/titular/{id}")
    public ResponseEntity<?> create(@Valid @PathVariable Long id, @RequestBody Estudiante estudiante, BindingResult result){
        Estudiante nuevoEstudiante = null;
        Titular titular = titularService.findAllById(id);
       // Titular estudianteGuardado = null;
        Map<String,Object> response = new HashMap<String,Object>();

        if (result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(n -> {return "El Campo '" + n.getField() + "' error " + n.getDefaultMessage();})
                    .collect(Collectors.toList());
        }
        try {
            //nuevoEstudiante.add(estudiante);
            //titular.setEstudiante(nuevoEstudiante);
            estudiante.setTitular(titular);
            //estudianteGuardado = titularService.insertTitular(titular);
            nuevoEstudiante = estudianteService.create(estudiante);

        }catch (DataAccessException e){
            response.put("mensaje","No se pudo ingresar al estudiante");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","Estudiante guardado exitosamente.");
        response.put("", nuevoEstudiante);
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/estudiantes/ci/{ci}")
    public ResponseEntity<?> findByCi(@PathVariable int ci){
        Estudiante estudiante = null;
        Map<String,Object> response = new HashMap<String,Object>();
        try {
            estudiante = estudianteService.findEstudianteByCelulaId(ci);
        }catch (DataAccessException e){
            response.put("mensaje","No optener el carnet de identidad del estudiante");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/estudiantes/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Estudiante estudiante = null;
        Map<String,Object> response = new HashMap<String,Object>();
        try {
            estudiante = estudianteService.findById(id);
        }catch (DataAccessException e){
            response.put("mensaje","No se puede encontrar al estudiante");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Estudiante>(estudiante, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Estudiante estudiante, @PathVariable Long id, BindingResult result) {
        Estudiante estudianteActual = estudianteService.findById(id);
        Estudiante nuevoEstudiante = null;

        Map<String, Object> response = new HashMap<>();
        if (result.hasErrors()) {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(n -> {
                        return "Error: " + n.getDefaultMessage();
                    })
                    .collect(Collectors.toList());
        }

        try {
            estudianteActual.setCodigoAlumno(estudiante.getCodigoAlumno());
            estudianteActual.setNombreCompleto(estudiante.getNombreCompleto());
            estudianteActual.setApellidoCompleto(estudiante.getApellidoCompleto());
            estudianteActual.setFechaNacimiento(estudiante.getFechaNacimiento());
            estudianteActual.setCelulaId(estudiante.getCelulaId());
            estudianteActual.setSexo(estudiante.getSexo());
            estudianteActual.setDireccion(estudiante.getDireccion());
            estudianteActual.setTelefono(estudiante.getTelefono());
            estudianteActual.setFechaIngreso(estudiante.getFechaIngreso());
            estudianteActual.setInscribir(estudiante.isInscribir());
            estudianteActual.setPromovido(estudiante.isPromovido());
            estudianteActual.setBaja(estudiante.isBaja());
            estudianteActual.setCursoRetiro(estudiante.isCursoRetiro());
            estudianteActual.setBaja(estudiante.isBaja());
            estudianteActual.setObservado(estudiante.isObservado());
            estudianteActual.setTextoObservado(estudiante.getTextoObservado());

            nuevoEstudiante = estudianteService.create(estudianteActual);

        } catch (DataAccessException e) {
            response.put("mensaje", "No se puede actualizar al estudiante");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Se actualizo correctamente al estudiante");
        response.put("", nuevoEstudiante);
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();
        try {
           // titularService.eliminarTitular(id);
            estudianteService.remove(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "No se pudo eliminar al estudiante");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Se elimino correctamente el estudiante");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
    /*@Secured("ROLE_ADMIN")
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<?> updateStudent(@Valid @RequestBody Estudiante estudiante, @RequestBody Conyugue conyugue, @PathVariable Long id, BindingResult result){

        Estudiante estudianteActual = estudianteService.findById(id);
        Estudiante estudianteActualizado = null;
        Map<String, Object> response = new HashMap<String, Object>();
        List<Biblioteca> biblioteca = new ArrayList<Biblioteca>();

        if (result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(n -> { return "El campo '".concat(n.getField()).concat("' ").concat(n.getDefaultMessage()); })
                    .collect(Collectors.toList());
        }

        if (estudianteActual == null){
            response.put("mensaje","No se pudo actualizar al estudiante con el id: "+id+" Puede que no exista.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try{

            estudianteActual.setNombre(estudiante.getNombre());
            estudianteActual.setApellido(estudiante.getApellido());
            estudianteActual.setCelulaId(estudiante.getCelulaId());
            estudianteActual.setBiblioteca(estudiante.getBiblioteca());

            estudianteActualizado = estudianteService.create(estudianteActual);
        }catch (DataAccessException e){
            response.put("mensaje","No se encontro el estudiante con el id: "+id);
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El estudiante se actualizo correctamente");
        response.put("estudiante", estudianteActualizado);
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.CREATED);
    }*/

   /* @Secured("ROLE_ADMIN")
    @GetMapping("/estudiantes/nombre/{nombre}")
    public ResponseEntity<?> findStudentByName(@PathVariable String nombre){
        List<Estudiante> lista = null;
        Map<String, Object> response = new HashMap<>();
        try {
            lista = estudianteService.findByNombreStartingWith(nombre);
        }catch (DataAccessException e){
            response.put("mensaje","No se pudo encontrar al estudiante");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<List<Estudiante>>(lista, HttpStatus.OK);
    }*/

}
