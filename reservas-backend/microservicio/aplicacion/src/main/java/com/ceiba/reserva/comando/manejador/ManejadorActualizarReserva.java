package com.ceiba.reserva.comando.manejador;

import com.ceiba.comando.ComandoReserva;
import com.ceiba.comando.fabrica.FabricaReserva;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.usuario.modelo.entidad.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarReserva implements ManejadorComando<ComandoReserva> {

    private final FabricaReserva fabricaReserva;
    private final ServicioActualizarReserva servicioActualizarReserva;

    public ManejadorActualizarReserva(FabricaReserva fabricaReserva, ServicioActualizarReserva servicioActualizarReserva) {
        this.fabricaReserva = fabricaReserva;
        this.servicioActualizarReserva = servicioActualizarReserva;
    }

    public void ejecutar(ComandoReserva comandoReserva) {
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        this.servicioActualizarReserva.ejecutar(reserva);
    }
}
