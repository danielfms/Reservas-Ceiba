package com.ceiba.avion.servicio;

import com.ceiba.usuario.modelo.entidad.Avion;
import com.ceiba.usuario.puerto.repositorio.RepositorioAvion;


public class ServicioCrearAvion {
	
    private final RepositorioAvion repositorioAvion;

    public ServicioCrearAvion(RepositorioAvion repositorioAvion) {
        this.repositorioAvion = repositorioAvion;
    }

    public Long ejecutar(Avion avion) {
        return this.repositorioAvion.crear(avion);
    }
}
