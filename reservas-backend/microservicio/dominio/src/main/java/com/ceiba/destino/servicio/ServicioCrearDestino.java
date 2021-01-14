package com.ceiba.destino.servicio;

import com.ceiba.usuario.modelo.entidad.Destino;
import com.ceiba.usuario.puerto.repositorio.RepositorioDestino;

public class ServicioCrearDestino {
	
    private final RepositorioDestino repositorioDestino;

    public ServicioCrearDestino(RepositorioDestino repositorioDestino) {
        this.repositorioDestino = repositorioDestino;
    }

    public Long ejecutar(Destino destino) {
        return this.repositorioDestino.crear(destino);
    }
}
