package com.ceiba.destino.servicio;

import com.ceiba.usuario.puerto.repositorio.RepositorioDestino;

public class ServicioEliminarDestino {
    
    private final RepositorioDestino repositorioDestino;

    public ServicioEliminarDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }

    public void ejecutar(Long id) {
        this.repositorioDestino.eliminar(id);
    }
}
