package com.registros.formularios.com.registros.formularios.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "estudiantes")
public class Estudiante implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo Codigo del titular es obligatorio")
    @Min(value = 1,message = "El campo Codigo del titular tiene que tener al menos un digito")
    @Column(nullable = false )
    private int codigotitular;

    @NotNull(message = "El campo Codigo de alumno es obligatorio")
    @Min(value = 1,message = "El campo Codigo alumno tiene que tener al menos un digito")
    @Column(nullable = false, unique = true )
    private int codigoAlumno;

    private String nombreCompleto;
    private String apellidoCompleto;

    @NotNull(message = "El campo Fecha Nacimiento es obligatorio")
    @Column(name = "fecha_nacimiento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "ci", nullable = true)
    private int celulaId;

    private String sexo;

    private String direccion;

    private int telefono;

    @NotNull(message = "El campo Fecha de Ingreso es obligatorio")
    @Column(name = "fecha_ingreso",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "estudiante", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("estudiante")
    private List<Biblioteca> biblioteca;

    private boolean inscribir;

    private boolean promovido;

    private boolean baja;

    private boolean cursoRetiro;

    private boolean banda;

    private boolean observado;
    private String textoObservado;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "profesor_id")
    @JsonIgnoreProperties("profesor")
    private Profesor profesor;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name="titular_id" )
    @JsonIgnoreProperties("titular")
    private Titular titular;

    public Estudiante(){
        this.biblioteca = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCodigotitular() {
        return codigotitular;
    }

    public void setCodigotitular(int codigotitular) {
        this.codigotitular = codigotitular;
    }

    public int getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApellidoCompleto() {
        return apellidoCompleto;
    }

    public void setApellidoCompleto(String apellidoCompleto) {
        this.apellidoCompleto = apellidoCompleto;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getCelulaId() {
        return celulaId;
    }

    public void setCelulaId(int celulaId) {
        this.celulaId = celulaId;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public List<Biblioteca> getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(List<Biblioteca> biblioteca) {
        this.biblioteca = biblioteca;
    }

    public boolean isInscribir() {
        return inscribir;
    }

    public void setInscribir(boolean inscribir) {
        this.inscribir = inscribir;
    }

    public boolean isPromovido() {
        return promovido;
    }

    public void setPromovido(boolean promovido) {
        this.promovido = promovido;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public boolean isCursoRetiro() {
        return cursoRetiro;
    }

    public void setCursoRetiro(boolean cursoRetiro) {
        this.cursoRetiro = cursoRetiro;
    }

    public boolean isBanda() {
        return banda;
    }

    public void setBanda(boolean banda) {
        this.banda = banda;
    }

    public boolean isObservado() {
        return observado;
    }

    public void setObservado(boolean observado) {
        this.observado = observado;
    }

    public String getTextoObservado() {
        return textoObservado;
    }

    public void setTextoObservado(String textoObservado) {
        this.textoObservado = textoObservado;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }


}
