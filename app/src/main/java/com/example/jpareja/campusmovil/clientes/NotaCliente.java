package com.example.jpareja.campusmovil.clientes;

import com.example.jpareja.campusmovil.dto.RespuestaMateria;
import com.example.jpareja.campusmovil.dto.RespuestaNotas;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * Created ºby cvrodriguez on 31/05/15.
 */
public interface NotaCliente {

    @GET("/nota/{idestudiante}/{idmateria}")
    RespuestaNotas verNotas(@Path("idmateria") Long materia, @Path("idestudiante") Long idestudiante);

}
