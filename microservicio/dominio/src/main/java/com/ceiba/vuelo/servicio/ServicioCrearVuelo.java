package com.ceiba.vuelo.servicio;

import com.ceiba.usuario.modelo.entidad.Vuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVuelo;


public class ServicioCrearVuelo {
	
    private final RepositorioVuelo repositorioVuelo;

    public ServicioCrearVuelo(RepositorioVuelo repositorioVuelo) {
        this.repositorioVuelo = repositorioVuelo;
    }

    public Long ejecutar(Vuelo usuario) {
        return this.repositorioVuelo.crear(usuario);
    }
}
