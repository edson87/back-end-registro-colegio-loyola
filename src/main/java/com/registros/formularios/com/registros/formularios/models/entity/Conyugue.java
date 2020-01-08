package com.registros.formularios.com.registros.formularios.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "conyugues")
public class Conyugue implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String primernombre;
    private String segundonombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private int ci;
    private String profesion;
    private String lugartrabajo;
    private int telefonotrabajo;
    private int celular;

    private String correo;
    private String sexo;
    private String apellidocasada;
    private String lugarnacimiento;

    //@OneToOne(mappedBy = "conyugue", fetch = FetchType.EAGER)
    @OneToOne
    @JsonIgnoreProperties("conyugue")
    private Titular titular;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getApellidopaterno() {
        return apellidopaterno;
    }

    public void setApellidopaterno(String apellidopaterno) {
        this.apellidopaterno = apellidopaterno;
    }

    public String getApellidomaterno() {
        return apellidomaterno;
    }

    public void setApellidomaterno(String apellidomaterno) {
        this.apellidomaterno = apellidomaterno;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getLugartrabajo() {
        return lugartrabajo;
    }

    public void setLugartrabajo(String lugartrabajo) {
        this.lugartrabajo = lugartrabajo;
    }

    public int getTelefonotrabajo() {
        return telefonotrabajo;
    }

    public void setTelefonotrabajo(int telefonotrabajo) {
        this.telefonotrabajo = telefonotrabajo;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getApellidocasada() {
        return apellidocasada;
    }

    public void setApellidocasada(String apellidocasada) {
        this.apellidocasada = apellidocasada;
    }

    public Titular getTitular() {
        return titular;
    }

    public void setTitular(Titular titular) {
        this.titular = titular;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }
}
