package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoVuelo;
import com.ceiba.usuario.modelo.entidad.Vuelo;
import org.springframework.stereotype.Component;

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

