package com.example.jpareja.campusmovil.dto;

import java.io.Serializable;

/**
 * Created by cvrodriguez on 31/05/15.
 */
public class RespuestaLogin implements Serializable{
    private Long idestudiante;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String programa;
    private Boolean ingresar;
    private String mensaje;


    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public Boolean getIngresar() {
        return ingresar;
    }

    public void setIngresar(Boolean ingresar) {
        this.ingresar = ingresar;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getIdestudiante() {
        return idestudiante;
    }

    public void setIdestudiante(Long idestudiante) {
        this.idestudiante = idestudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }
}
