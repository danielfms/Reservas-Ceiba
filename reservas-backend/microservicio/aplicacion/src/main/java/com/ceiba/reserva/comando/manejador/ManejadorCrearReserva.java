package com.ceiba.reserva.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.comando.ComandoReserva;
import com.ceiba.comando.fabrica.FabricaReserva;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.usuario.modelo.entidad.Reserva;

import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearReserva implements ManejadorComandoRespuesta<ComandoReserva, ComandoRespuesta<Long>> {

    private final FabricaReserva fabricaReserva;
    private final ServicioCrearReserva servicioCrearReserva;
    

    public ManejadorCrearReserva(FabricaReserva fabricaReserva, ServicioCrearReserva servicioCrearReserva) {
        this.fabricaReserva = fabricaReserva;
        this.servicioCrearReserva = servicioCrearReserva;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoReserva comandoReserva) {
        Reserva reserva = this.fabricaReserva.crear(comandoReserva);
        return new ComandoRespuesta<>(this.servicioCrearReserva.ejecutar(reserva));
    }
}
