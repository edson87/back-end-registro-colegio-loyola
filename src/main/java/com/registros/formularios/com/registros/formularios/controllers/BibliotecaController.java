package com.registros.formularios.com.registros.formularios.controllers;

import com.registros.formularios.com.registros.formularios.models.entity.Biblioteca;
import com.registros.formularios.com.registros.formularios.models.entity.Estudiante;
import com.registros.formularios.com.registros.formularios.models.services.IBibliotecaService;
import com.registros.formularios.com.registros.formularios.models.services.IEstudianteService;
import org.apache.tomcat.jni.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/bibliotecaApi")
public class BibliotecaController {

    @Autowired
    private IBibliotecaService bibliotecaService;
    @Autowired
    private IEstudianteService estudianteService;

    private final Logger log = LoggerFactory.getLogger(EstudianteController.class);


    @GetMapping("/libros")
    @ResponseStatus(HttpStatus.OK)
    public List<Biblioteca> index(){
        return bibliotecaService.findAll();
    }

    @PostMapping("/libros")
    @ResponseStatus(HttpStatus.CREATED)
    public Biblioteca create(@RequestBody Biblioteca biblioteca){
        return bibliotecaService.save(biblioteca);
    }

    @GetMapping("/libros/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> findBookById(@PathVariable Long id){
        Biblioteca libroActual = null;
        Map<String, Object> response = new HashMap<>();

        try{
            libroActual = bibliotecaService.finById(id);
        }catch (DataAccessException e){
            response.put("mensaje","Hubo un error en la busqueda del libro");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if (libroActual == null){
            response.put("mensaje","No existe es libro de id: ".concat(id.toString()));
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Biblioteca>(libroActual, HttpStatus.OK);
    }

    @PutMapping("/libros/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update (@RequestBody Biblioteca biblioteca, @PathVariable Long id){

        Biblioteca libroActual = bibliotecaService.finById(id);;
        Biblioteca libroActualizado = null;
        Map<String, Object> response = new HashMap<>();

        if (libroActual == null){
            response.put("mensaje","No se encontro el libro con el id: " + id);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            libroActual.setTitulo(biblioteca.getTitulo());
            libroActual.setAutor(biblioteca.getAutor());
            libroActual.setFechaEntrega(biblioteca.getFechaEntrega());
            libroActual.setFechaSalida(biblioteca.getFechaSalida());
            libroActual.setObservaciones(biblioteca.getObservaciones());

            libroActualizado = bibliotecaService.save(libroActual);
        }catch (DataAccessException e){
            response.put("mensaje","No se puedo actualizar la biblioteca");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","El libro "+ libroActual.getTitulo() +" se actualizo correctamente");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
    }

    @PutMapping("/libro/estudiante/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> rentBook (@RequestBody List<Biblioteca> biblioteca, @PathVariable Long id){

        Biblioteca libroActual = null;
        Biblioteca libroActualizado = null;
        Estudiante est = null;
        List<Biblioteca> listBiblioteca = new ArrayList<>();
        Map<String, Object> response = new HashMap<>();

        if (libroActual == null){
            response.put("mensaje","No se encontro el libro con el id: " + id);
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
        }
        try{
            /*libroActual.setTitulo(biblioteca.getTitulo());
            libroActual.setAutor(biblioteca.getAutor());
            libroActual.setFechaEntrega(biblioteca.getFechaEntrega());
            libroActual.setFechaSalida(biblioteca.getFechaSalida());
            libroActual.setObservaciones(biblioteca.getObservaciones());*/
            est = estudianteService.findById(id);
            for (Biblioteca libro:biblioteca ) {
                //libroActual = bibliotecaService.finById(libro.getId());

                libro.setEstudiante(est);
                libroActualizado = bibliotecaService.save(libro);
            }

            //libroActual.setEstudiante(biblioteca.getEstudiante());

            //libroActualizado = bibliotecaService.save(libroActual);
        }catch (DataAccessException e){
            response.put("mensaje","No se puedo actualizar la biblioteca");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Biblioteca>(libroActualizado, HttpStatus.CREATED);
    }

    @DeleteMapping("/libros/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){

        Map<String, Object> response = new HashMap<>();
        try {
            bibliotecaService.delete(id);
        }catch (DataAccessException e){
            response.put("mensaje","No se pudo eliminar el libro");
            response.put("error",e.getCause());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje","Se elimino correctamente el libro.");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/libros/reservas")
    public ResponseEntity<?> findLibraryDateNull(){
        return new ResponseEntity<Biblioteca>(bibliotecaService.findAllByFechaEntregaIsNull(), HttpStatus.OK);
    }

    @GetMapping("/libros/titulo/{titulo}")
    public ResponseEntity<?> findBookByTitle(@PathVariable String titulo){
        List<Biblioteca> bibliotecas = null;
        Map<String,Object> response = new HashMap<>();
        try{
            bibliotecas = bibliotecaService.findByTituloStartingWith(titulo);
        }catch (DataAccessException e){
            response.put("error","No se pudo encontrar el titulo");
            response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
        }
        return new ResponseEntity<List<Biblioteca>>(bibliotecas, HttpStatus.OK);
    }

    @PutMapping("/libros/devolver/{id}")
    public ResponseEntity<?> returnBook(@PathVariable Long id){
        Biblioteca libros = null;
        Map<String,Object> response = new HashMap<>();

        try{
            libros = bibliotecaService.finById(id);
            libros.setFechaEntrega(null);
            libros.setFechaSalida(null);
            libros.setEstudiante(null);
            bibliotecaService.save(libros);
        }catch(DataAccessException e){
            response.put("mensaje","No se encontro el libro");
            response.put("error",e.getMessage().concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Biblioteca>(libros, HttpStatus.OK);
    }

}
