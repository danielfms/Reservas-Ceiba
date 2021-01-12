package com.ceiba.vuelo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.vuelo.servicio.ServicioEliminarVuelo;

import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarVuelo implements ManejadorComando<Long> {

    private final ServicioEliminarVuelo servicioEliminarVuelo;

    public ManejadorEliminarVuelo(ServicioEliminarVuelo servicioEliminarVuelo) {
        this.servicioEliminarVuelo = servicioEliminarVuelo;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarVuelo.ejecutar(idUsuario);
    }
}
