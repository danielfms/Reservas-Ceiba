package com.ceiba.destino.comando.manejador;

import com.ceiba.destino.servicio.ServicioActualizarDestino;
import com.ceiba.manejador.ManejadorComando;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoDestino;
import com.ceiba.usuario.comando.fabrica.FabricaDestino;
import com.ceiba.usuario.modelo.entidad.Destino;


@Component
public class ManejadorActualizarDestino implements ManejadorComando<ComandoDestino> {

    private final FabricaDestino fabricaDestino;
    private final ServicioActualizarDestino servicioActualizarDestino;

    public ManejadorActualizarDestino(FabricaDestino fabricaDestino, ServicioActualizarDestino servicioActualizarDestino) {
        this.fabricaDestino = fabricaDestino;
        this.servicioActualizarDestino = servicioActualizarDestino;
    }

    public void ejecutar(ComandoDestino comandoDestino) {
        Destino destino = this.fabricaDestino.crear(comandoDestino);
        this.servicioActualizarDestino.ejecutar(destino);
    }
}
