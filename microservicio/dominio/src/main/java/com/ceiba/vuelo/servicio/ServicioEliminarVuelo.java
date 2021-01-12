package com.ceiba.vuelo.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioVuelo;

public class ServicioEliminarVuelo {
    
    private final RepositorioVuelo repositorioVuelo;

    public ServicioEliminarVuelo(RepositorioVuelo repositorioVuelo) {
        this.repositorioVuelo = repositorioVuelo;
    }

    public void ejecutar(Long id) {
        this.repositorioVuelo.eliminar(id);
    }
}
