package com.ceiba.vuelo.servicio;

import com.ceiba.usuario.modelo.entidad.Vuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVuelo;

public class ServicioActualizarVuelo {


    private final RepositorioVuelo repositorioVuelo;

    public ServicioActualizarVuelo(RepositorioVuelo repositorioVuelo) {
        this.repositorioVuelo = repositorioVuelo;
    }

    public void ejecutar(Vuelo usuario) {
        this.repositorioVuelo.actualizar(usuario);
    }

}
