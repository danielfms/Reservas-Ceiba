package com.ceiba.destino.servicio;

import com.ceiba.usuario.modelo.entidad.Destino;
import com.ceiba.usuario.puerto.repositorio.RepositorioDestino;

public class ServicioActualizarDestino {

    private final RepositorioDestino repositorioDestino;

    public ServicioActualizarDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }

    public void ejecutar(Destino destino) {
        this.repositorioDestino.actualizar(destino);
    }

}
