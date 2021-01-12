package com.ceiba.avion.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.avion.servicio.ServicioCrearAvion;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Avion;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAvion;
import com.ceiba.usuario.comando.fabrica.FabricaAvion;

@Component
public class ManejadorCrearAvion implements ManejadorComandoRespuesta<ComandoAvion, ComandoRespuesta<Long>> {

    private final FabricaAvion fabricaAvion;
    private final ServicioCrearAvion servicioCrearAvion;

    public ManejadorCrearAvion(FabricaAvion fabricaAvion, ServicioCrearAvion servicioCrearAvion) {
        this.fabricaAvion = fabricaAvion;
        this.servicioCrearAvion = servicioCrearAvion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoAvion comandoAvion) {
        Avion avion = this.fabricaAvion.crear(comandoAvion);
        return new ComandoRespuesta<>(this.servicioCrearAvion.ejecutar(avion));
    }
}
