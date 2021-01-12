package com.ceiba.vuelo.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.modelo.entidad.Vuelo;
import com.ceiba.vuelo.servicio.ServicioActualizarVuelo;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoVuelo;
import com.ceiba.usuario.comando.fabrica.FabricaVuelo;

@Component
public class ManejadorActualizarVuelo implements ManejadorComando<ComandoVuelo> {

    private final FabricaVuelo fabricaVuelo;
    private final ServicioActualizarVuelo servicioActualizarVuelo;

    public ManejadorActualizarVuelo(FabricaVuelo fabricaVuelo, ServicioActualizarVuelo servicioActualizarVuelo) {
        this.fabricaVuelo = fabricaVuelo;
        this.servicioActualizarVuelo = servicioActualizarVuelo;
    }

    public void ejecutar(ComandoVuelo comandoVuelo) {
        Vuelo vuelo = this.fabricaVuelo.crear(comandoVuelo);
        this.servicioActualizarVuelo.ejecutar(vuelo);
    }
}
