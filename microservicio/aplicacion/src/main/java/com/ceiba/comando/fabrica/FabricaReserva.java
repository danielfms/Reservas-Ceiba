package com.ceiba.comando.fabrica;

import com.ceiba.comando.ComandoReserva;
import com.ceiba.usuario.modelo.entidad.Reserva;
import org.springframework.stereotype.Component;

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
        		comandoReserva.getActiva(), 
        		comandoReserva.getToken(),
        		comandoReserva.getFechaCreacion()
        );
    }

}
