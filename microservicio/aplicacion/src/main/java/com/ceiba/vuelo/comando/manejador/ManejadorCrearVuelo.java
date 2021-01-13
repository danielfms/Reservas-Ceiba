package com.ceiba.vuelo.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoVuelo;
import com.ceiba.comando.fabrica.FabricaVuelo;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.usuario.modelo.entidad.Vuelo;
import com.ceiba.vuelo.servicio.ServicioCrearVuelo;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearVuelo implements ManejadorComandoRespuesta<ComandoVuelo, ComandoRespuesta<Long>> {

    private final FabricaVuelo fabricaVuelo;
    private final ServicioCrearVuelo servicioCrearVuelo;


    public ManejadorCrearVuelo(FabricaVuelo fabricaVuelo, ServicioCrearVuelo servicioCrearVuelo) {
        this.fabricaVuelo = fabricaVuelo;
        this.servicioCrearVuelo = servicioCrearVuelo;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoVuelo comandoVuelo) {
        Vuelo vuelo = this.fabricaVuelo.crear(comandoVuelo);
        return new ComandoRespuesta<>(this.servicioCrearVuelo.ejecutar(vuelo));
    }
}
