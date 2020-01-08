package com.registros.formularios.com.registros.formularios.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "titulares")
public class Titular implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El campo Codigo de Titular es obligatorio")
    @Min(value = 1,message = "El campo Codigo Titular tiene que tener al menos un digito")
    @Column(nullable = false, unique = true )
    private int codigotitular;

    @NotBlank(message = "El campo Primer Nombre es obligatorio")
    @Column(nullable = false)
    private String primernombre;
    private String segundonombre;

    @NotBlank(message = "El campo Apellido Paterno es obligatorio")
    @Column(nullable = false)
    private String apellidopaterno;

    @NotBlank(message = "El campo Apellido Materno es obligatorio")
    @Column(nullable = false)
    private String apellidomaterno;

    private int ci;

    @NotBlank(message = "El campo Profecion es obligatorio")
    @Column(nullable = false)
    private String profesion;

    private String lugartrabajo;
    private int telefonotrabajo;

    @NotNull(message = "El campo Celular es obligatorio")
    @Min(1)
    @Column(nullable = false)
    private int celular;

    @NotNull(message = "El campo correo es obligatorio")
    @NotEmpty
    @Email
    @Column(nullable = false)
    private String correo;

    private String sexo;

    private boolean activo;

    private boolean observado;

    private boolean inscribir;

    @NotNull(message = "El campo Fecha Ingreso es obligatorio")
    @Column(name = "fecha_ingreso",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;

    @Column(name = "fecha_baja",nullable = true)
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    @NotNull(message = "El campo Fecha Nacimiento es obligatorio")
    @Column(name = "fecha_nacimiento",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    private String lugarnacimiento;

    private String estadocivil;

    private String direccion;

    //@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = true)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "conyugue_id")
    @JsonIgnoreProperties(value = "conyugue")
    private Conyugue conyugue;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "titular")
    @JsonIgnoreProperties("titular")
    private List<Estudiante> estudiante;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,mappedBy = "titular")
    @JsonIgnoreProperties("titular")
    private List<Contrato> contrato;

    public Titular(){
        estudiante = new ArrayList<Estudiante>();
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isObservado() {
        return observado;
    }

    public void setObservado(boolean observado) {
        this.observado = observado;
    }

    public boolean isInscribir() {
        return inscribir;
    }

    public void setInscribir(boolean inscribir) {
        this.inscribir = inscribir;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getLugarnacimiento() {
        return lugarnacimiento;
    }

    public void setLugarnacimiento(String lugarnacimiento) {
        this.lugarnacimiento = lugarnacimiento;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public Conyugue getConyugue() {
        return conyugue;
    }

    public void setConyugue(Conyugue conyugue) {
        this.conyugue = conyugue;
    }

    public List<Estudiante> getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(List<Estudiante> estudiante) {
        this.estudiante = estudiante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Contrato> getContrato() {
        return contrato;
    }

    public void setContrato(List<Contrato> contrato) {
        this.contrato = contrato;
    }
}
