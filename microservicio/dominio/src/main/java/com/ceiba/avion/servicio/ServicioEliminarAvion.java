package com.ceiba.avion.servicio;


import com.ceiba.usuario.puerto.repositorio.RepositorioAvion;

public class ServicioEliminarAvion {
    
    private final RepositorioAvion repositorioAvion;

    public ServicioEliminarAvion(RepositorioAvion repositorioAvion) {
        this.repositorioAvion = repositorioAvion;
    }

    public void ejecutar(Long id) {
        this.repositorioAvion.eliminar(id);
    }
}
