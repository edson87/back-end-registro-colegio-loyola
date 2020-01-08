package com.registros.formularios.com.registros.formularios.controllers;

import com.registros.formularios.com.registros.formularios.models.entity.Titular;
import com.registros.formularios.com.registros.formularios.models.services.TitularServiceImpl;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/titularApi")
public class TitularController {
    @Autowired
    private TitularServiceImpl titularService;


    @Secured("ROLE_ADMIN")
    @GetMapping("/titulares")
    @ResponseStatus(HttpStatus.OK)
    public List<Titular> findAll(){
        return titularService.findAll();
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/titulares/page/{page}")
    @ResponseStatus(HttpStatus.OK)
    public Page<Titular> findAll(@PathVariable Integer page){
        Pageable pageable = PageRequest.of(page,10);
        return titularService.findAll(pageable);
    }


    @Secured("ROLE_ADMIN")
    @PostMapping("/titulares")
    public ResponseEntity<?> save(@Valid @RequestBody Titular titular, BindingResult result){
        Titular nuevoTitular = null;
        Map<String,Object> response = new HashMap<>();

        if(result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(e ->  "Error: " + e.getDefaultMessage())
                    .collect(Collectors.toList());
            response.put("error", errors);
            return new ResponseEntity<Map<String,Object>>(response ,HttpStatus.BAD_REQUEST);
        }

        if (titular == null){
            response.put("mensaje","El contenido ingresado esta vacio");
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);

        }

        try {
            nuevoTitular = titularService.insertTitular(titular);
        }catch (DataAccessException e){
            response.put("mensaje","No se pude ingresar al titular");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","Se guardaron correctamente los datos.");
        response.put("",nuevoTitular);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @GetMapping("/titulares/{id}")
    public ResponseEntity<?> obtenerTitularById(@PathVariable Long id)
    {
        Titular titular = null;
        Map<String, Object> response = new HashMap<>();

        if(id == null){
            response.put("mensaje","El id del titular ingresado no existe");
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            titular = titularService.findAllById(id);
        }catch (DataAccessException e){
            response.put("mensaje","No se puede encontrar al titular");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Titular>(titular,HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/titulares/{id}")
    public ResponseEntity<?> actualizarTitular(@Valid @PathVariable Long id, @RequestBody Titular titular, BindingResult result){
        Titular antiguoTitular = titularService.findAllById(id);
        Titular nuevoTitular = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (result.hasErrors())
        {
            List<String> errors = result.getFieldErrors()
                    .stream()
                    .map(e ->  "Error: "+ e.getDefaultMessage() )
                    .collect(Collectors.toList());
        }

        if (antiguoTitular == null){
            response.put("mensaje","No se pudo actualizar al titular con el id: "+id+" Puede que no exista.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {

            antiguoTitular.setCodigotitular(titular.getCodigotitular());
            antiguoTitular.setPrimernombre(titular.getPrimernombre());
            antiguoTitular.setSegundonombre(titular.getSegundonombre());
            antiguoTitular.setApellidomaterno(titular.getApellidomaterno());
            antiguoTitular.setApellidomaterno(titular.getApellidomaterno());
            antiguoTitular.setCi(titular.getCi());
            antiguoTitular.setProfesion(titular.getProfesion());
            antiguoTitular.setLugartrabajo(titular.getLugartrabajo());
            antiguoTitular.setTelefonotrabajo(titular.getTelefonotrabajo());
            antiguoTitular.setCelular(titular.getCelular());
            antiguoTitular.setCorreo(titular.getCorreo());
            antiguoTitular.setSexo(titular.getSexo());
            antiguoTitular.setActivo(titular.isActivo());
            antiguoTitular.setFechaIngreso(titular.getFechaIngreso());
            antiguoTitular.setFechaBaja(titular.getFechaBaja());
            antiguoTitular.setFechaNacimiento(titular.getFechaNacimiento());
            antiguoTitular.setLugartrabajo(titular.getLugartrabajo());
            antiguoTitular.setEstadocivil(titular.getEstadocivil());
            antiguoTitular.setDireccion(titular.getDireccion());
            antiguoTitular.setConyugue(titular.getConyugue());

            nuevoTitular = titularService.insertTitular(antiguoTitular);
        }catch (DataAccessException e){
            response.put("mensaje","No se pude actualizar al titular");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","Se actualizo correctamente los datos.");
        response.put("",nuevoTitular);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/titulares/{id}")
    public ResponseEntity<?> eliminarTitular(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();

        try{
            titularService.eliminarTitular(id);
        }catch (DataAccessException e){
            response.put("mensaje","No se pude eliminar al titular");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","Se elimino correctamente al titular");
        return new ResponseEntity<Map<String, Object>>(response,HttpStatus.OK);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/titulares/eliminar/conyugue/{id}")
    public ResponseEntity<?> eliminarConyugueByTitularId(@PathVariable Long id){
        Titular antiguoTitular = titularService.findAllById(id);
        Titular nuevoTitular = null;
        Map<String, Object> response = new HashMap<String, Object>();

        if (antiguoTitular == null){
            response.put("mensaje","No se pudo actualizar al titular con el id: "+id+" Puede que no exista.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {

            antiguoTitular.setConyugue(null);

            nuevoTitular = titularService.insertTitular(antiguoTitular);
        }catch (DataAccessException e){
            response.put("mensaje","No se pude eliminar al conyugue");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje","Se elimino correctamente los datos del conyugue.");
        response.put("",nuevoTitular);
        return new ResponseEntity<Map<String,Object>>(response,HttpStatus.CREATED);
    }

    @Secured({"ROLE_ADMIN","ROLE_TECNO"})
    @GetMapping("/titulares/codigo&&titular/{id}")
    public ResponseEntity<?> obtenerTitularByCi(@PathVariable int id){
        Titular titular = null;
        Map<String, Object> response = new HashMap<>();

        if(id == 0){
            response.put("mensaje","El carnet de identidad del titular ingresado no existe");
            return  new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }

        try {
            titular = titularService.findByCodigotitular(id);
        }catch (DataAccessException e){
            response.put("mensaje","No se puede encontrar al titular");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Titular>(titular,HttpStatus.OK);
    }
}
