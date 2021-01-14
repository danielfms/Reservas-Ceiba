package com.ceiba.avion.servicio;

import com.ceiba.usuario.modelo.entidad.Avion;
import com.ceiba.usuario.puerto.repositorio.RepositorioAvion;

public class ServicioActualizarAvion {


    private final RepositorioAvion repositorioAvion;

    public ServicioActualizarAvion(RepositorioAvion repositorioAvion) {
        this.repositorioAvion = repositorioAvion;
    }

    public void ejecutar(Avion avion) {
        this.repositorioAvion.actualizar(avion);
    }

}
