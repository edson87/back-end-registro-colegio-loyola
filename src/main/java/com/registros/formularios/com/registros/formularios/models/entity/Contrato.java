package com.registros.formularios.com.registros.formularios.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "contratos")
public class Contrato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreCompleto;
    private String apellidos;

    private int codigoTitular;
    private int CodigoAlumno;
    private String codigoCurso;
    private String curso;

    @NotNull(message = "El campo gestion es obligatorio")
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date gestion;

    private int telefono;

    private String direccion;

    @ManyToOne(optional = true)
    @JoinColumn(name="titular_id" )
    @JsonIgnoreProperties("titular")
    private Titular titular;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getCodigoTitular() {
        return codigoTitular;
    }

    public void setCodigoTitular(int codigoTitular) {
        this.codigoTitular = codigoTitular;
    }

    public int getCodigoAlumno() {
        return CodigoAlumno;
    }

    public void setCodigoAlumno(int codigoAlumno) {
        CodigoAlumno = codigoAlumno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Date getGestion() {
        return gestion;
    }

    public void setGestion(Date gestion) {
        this.gestion = gestion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }
}
