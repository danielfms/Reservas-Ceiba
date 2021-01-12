package com.ceiba.destino.comando.manejador;

import com.ceiba.destino.servicio.ServicioEliminarDestino;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarDestino implements ManejadorComando<Long> {

    private final ServicioEliminarDestino servicioEliminarDestino;

    public ManejadorEliminarDestino(ServicioEliminarDestino servicioEliminarDestino) {
        this.servicioEliminarDestino = servicioEliminarDestino;
    }

    public void ejecutar(Long id) {
        this.servicioEliminarDestino.ejecutar(id);
    }
}
