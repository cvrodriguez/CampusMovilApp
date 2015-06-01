package com.example.jpareja.campusmovil.dto;

/**
 * Created by cvrodriguez on 31/05/15.
 */
public class RespuestaLogin {
    private Long identificacion;
    private Boolean ingresar;
    private String mensaje;


    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
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
}
