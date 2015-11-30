package com.example.jpareja.campusmovil.clientes;

import com.example.jpareja.campusmovil.dto.RespuestaMatricula;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created ºby cvrodriguez on 31/05/15.
 */
public interface MatriculaCliente {

    @GET("/materiaXSemestre/{idsemestre}")
    List<RespuestaMatricula> verMateriaXSeme(@Path("idsemestre") Integer idSemestre);

}
