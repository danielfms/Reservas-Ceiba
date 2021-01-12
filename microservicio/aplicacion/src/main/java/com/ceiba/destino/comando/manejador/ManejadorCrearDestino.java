package com.ceiba.destino.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.destino.servicio.ServicioCrearDestino;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Destino;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoDestino;
import com.ceiba.usuario.comando.fabrica.FabricaDestino;

@Component
public class ManejadorCrearDestino implements ManejadorComandoRespuesta<ComandoDestino, ComandoRespuesta<Long>> {

    private final FabricaDestino fabricaDestino;
    private final ServicioCrearDestino servicioCrearDestino;

    public ManejadorCrearDestino(FabricaDestino fabricaDestino, ServicioCrearDestino servicioCrearDestino) {
        this.fabricaDestino = fabricaDestino;
        this.servicioCrearDestino = servicioCrearDestino;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoDestino comandoDestino) {
        Destino destino = this.fabricaDestino.crear(comandoDestino);
        return new ComandoRespuesta<>(this.servicioCrearDestino.ejecutar(destino));
    }
}
