package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Vuelo;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.comando.ComandoVuelo;

@Component
public class FabricaVuelo {

    public Vuelo crear(ComandoVuelo comandoVuelo) {
        return new Vuelo(
        		comandoVuelo.getId(),
        		comandoVuelo.getIdDestino(),
        		comandoVuelo.getIdAvion(),
        		comandoVuelo.getFecha(),
        		comandoVuelo.getDuracion()
        );
    }

}

