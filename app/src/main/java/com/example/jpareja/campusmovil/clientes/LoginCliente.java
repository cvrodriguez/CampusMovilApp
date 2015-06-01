package com.example.jpareja.campusmovil.clientes;

import com.example.jpareja.campusmovil.dto.RespuestaLogin;

import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created ºby cvrodriguez on 31/05/15.
 */
public interface LoginCliente {

    @GET("/login/{user}/{clave}/")
    RespuestaLogin login(@Path("user")String identificacion, @Path("clave")String clave);

}
