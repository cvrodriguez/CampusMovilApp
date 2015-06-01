package com.example.jpareja.campusmovil.clientes;

import com.example.jpareja.campusmovil.dto.RespuestaMateria;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

/**
 * Created ºby cvrodriguez on 31/05/15.
 */
public interface MateriaCliente {

    @GET("/materia/{idmatricula}")
    List<RespuestaMateria> listarMaterias(@Path("idmatricula") Long idMatricula);

}
