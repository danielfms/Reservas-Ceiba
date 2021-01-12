package com.ceiba.avion.comando.manejador;

import com.ceiba.avion.servicio.ServicioEliminarAvion;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarAvion implements ManejadorComando<Long> {

    private final ServicioEliminarAvion servicioEliminarAvion;

    public ManejadorEliminarAvion(ServicioEliminarAvion servicioEliminarAvion) {
        this.servicioEliminarAvion = servicioEliminarAvion;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarAvion.ejecutar(id);
    }
}
