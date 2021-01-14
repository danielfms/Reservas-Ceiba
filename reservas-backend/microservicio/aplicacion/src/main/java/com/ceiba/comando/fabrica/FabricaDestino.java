package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoDestino;
import com.ceiba.usuario.modelo.entidad.Destino;
import org.springframework.stereotype.Component;

@Component
public class FabricaDestino {

    public Destino crear(ComandoDestino comandoDestino) {
        return new Destino(
                comandoDestino.getId(),
                comandoDestino.getCiudadOrigen(),
                comandoDestino.getCiudadDestino(),
                comandoDestino.getValorBase()
        );
    }

}
