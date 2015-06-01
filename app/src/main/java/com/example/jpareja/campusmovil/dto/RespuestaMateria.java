package com.example.jpareja.campusmovil.dto;

import java.util.Objects;

/**
 * Created by pbastidas on 6/1/15.
 */
public class RespuestaMateria {
    private Long idmateria;
    private String nombre;
    private Double nota;

    public RespuestaMateria() {
    }

    public RespuestaMateria(Long idmateria) {

        this.idmateria = idmateria;
    }

    public RespuestaMateria(Long idmateria, String nombre, Double nota) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.nota = nota;
    }

    public Long getIdmateria() {

        return idmateria;
    }

    public void setIdmateria(Long idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaMateria that = (RespuestaMateria) o;
        return Objects.equals(idmateria, that.idmateria) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(nota, that.nota);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmateria, nombre, nota);
    }
}
