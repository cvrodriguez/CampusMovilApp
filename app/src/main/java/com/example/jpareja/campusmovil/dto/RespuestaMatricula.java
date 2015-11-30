package com.example.jpareja.campusmovil.dto;

import java.util.Objects;

/**
 * Created by cvrodriguez on 28/11/15.
 */
public class RespuestaMatricula {

private  String nombre;
    private int idsemestre;
    private int idmateria;

    public RespuestaMatricula() {
    }

    public RespuestaMatricula(int idmateria, int idsemestre, String nombre) {
        this.idmateria = idmateria;
        this.idsemestre = idsemestre;
        this.nombre = nombre;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public int getIdsemestre() {
        return idsemestre;
    }

    public void setIdsemestre(int idsemestre) {
        this.idsemestre = idsemestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaMatricula that = (RespuestaMatricula) o;
        return Objects.equals(idmateria, that.idmateria) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(idsemestre, that.idsemestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmateria, nombre, idsemestre);
    }
}

