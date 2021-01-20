package com.ceiba.reserva.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.reserva.servicio.ServicioConsultarReserva;
import com.ceiba.usuario.modelo.dto.DtoReserva;

@Component
public class ManejadorConsultarReserva {

    private final ServicioConsultarReserva servicioConsultarReserva;

    public ManejadorConsultarReserva(ServicioConsultarReserva servicioConsultarReserva){
        this.servicioConsultarReserva = servicioConsultarReserva;
    }
    
    public DtoReserva ejecutar(Long id){
    	return this.servicioConsultarReserva.ejecutar(id); 
    }
}
