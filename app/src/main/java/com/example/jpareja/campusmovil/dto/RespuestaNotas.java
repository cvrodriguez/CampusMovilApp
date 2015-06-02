package com.example.jpareja.campusmovil.dto;

import java.util.Objects;

/**
 * Created by cvrodriguez on 6/1/15.
 */
public class RespuestaNotas {
    private Long idmateria;
    private Long matricula;
    private String nombreMateria;
    private Double primerp;
    private Double segundop;
    private Double tercerp;
    private Double notasvarias;
    private Double notaproyecto;

    public RespuestaNotas() {
    }

    public RespuestaNotas(Long idmateria) {

        this.idmateria = idmateria;
    }

    public Long getIdmateria() {

        return idmateria;
    }

    public void setIdmateria(Long idmateria) {
        this.idmateria = idmateria;
    }

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(Long matricula) {
        this.matricula = matricula;
    }

    public String getNombreMateria() {
        return nombreMateria;
    }

    public void setNombreMateria(String nombreMateria) {
        this.nombreMateria = nombreMateria;
    }

    public Double getPrimerp() {
        return primerp;
    }

    public void setPrimerp(Double primerp) {
        this.primerp = primerp;
    }

    public Double getSegundop() {
        return segundop;
    }

    public void setSegundop(Double segundop) {
        this.segundop = segundop;
    }

    public Double getTercerp() {
        return tercerp;
    }

    public void setTercerp(Double tercerp) {
        this.tercerp = tercerp;
    }

    public Double getNotasvarias() {
        return notasvarias;
    }

    public void setNotasvarias(Double notasvarias) {
        this.notasvarias = notasvarias;
    }

    public Double getNotaproyecto() {
        return notaproyecto;
    }

    public void setNotaproyecto(Double notaproyecto) {
        this.notaproyecto = notaproyecto;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaNotas that = (RespuestaNotas) o;
        return Objects.equals(idmateria, that.idmateria) &&
                Objects.equals(matricula, that.matricula) &&
                Objects.equals(nombreMateria, that.nombreMateria) &&
                Objects.equals(primerp, that.primerp) &&
                Objects.equals(segundop, that.segundop) &&
                Objects.equals(tercerp, that.tercerp) &&
                Objects.equals(notasvarias, that.notasvarias) &&
                Objects.equals(notaproyecto, that.notaproyecto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmateria, matricula, nombreMateria, primerp, segundop, tercerp, notasvarias, notaproyecto);
    }
}
