package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Destino;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.comando.ComandoDestino;

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
