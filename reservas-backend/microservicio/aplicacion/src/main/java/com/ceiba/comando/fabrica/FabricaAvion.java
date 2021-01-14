package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoAvion;
import com.ceiba.usuario.modelo.entidad.Avion;
import org.springframework.stereotype.Component;

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
