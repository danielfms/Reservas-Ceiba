package com.ceiba.usuario.comando.fabrica;

import com.ceiba.usuario.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;
import com.ceiba.usuario.comando.ComandoReserva;

@Component
public class FabricaReserva {

    public Reserva crear(ComandoReserva comandoReserva) {
        return new Reserva(
        		comandoReserva.getId(),
        		comandoReserva.getIdVuelo(),
        		comandoReserva.getTipoIdentificacion(),
        		comandoReserva.getNumeroIdentificacion(),
        		comandoReserva.getPasajeros(),
        		comandoReserva.getValorTotal(),
        		comandoReserva.getActivo(), 
        		comandoReserva.getToken(),
        		comandoReserva.getFechaCreacion()
        );
    }

}
