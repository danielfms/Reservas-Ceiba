package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Avion;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.comando.ComandoAvion;

@Component
public class FabricaAvion {

    public Avion crear(ComandoAvion comandoAvion) {
        return new Avion(
                comandoAvion.getId(),
                comandoAvion.getMatricula(),
                comandoAvion.getPasajeros()
        );
    }

}
