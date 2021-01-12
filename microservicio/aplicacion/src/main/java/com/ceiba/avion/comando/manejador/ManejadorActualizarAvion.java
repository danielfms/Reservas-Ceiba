package com.ceiba.avion.comando.manejador;

import com.ceiba.avion.servicio.ServicioActualizarAvion;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.modelo.entidad.Avion;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAvion;
import com.ceiba.usuario.comando.fabrica.FabricaAvion;

@Component
public class ManejadorActualizarAvion implements ManejadorComando<ComandoAvion> {

    private final FabricaAvion fabricaAvion;
    private final ServicioActualizarAvion servicioActualizarAvion;

    public ManejadorActualizarAvion(FabricaAvion fabricaAvion, ServicioActualizarAvion servicioActualizarAvion) {
        this.fabricaAvion = fabricaAvion;
        this.servicioActualizarAvion = servicioActualizarAvion;
    }

    public void ejecutar(ComandoAvion comandoAvion) {
        Avion avion = this.fabricaAvion.crear(comandoAvion);
        this.servicioActualizarAvion.ejecutar(avion);
    }
}
