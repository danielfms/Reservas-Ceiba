package com.ceiba.reserva.servicio;

import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.modelo.dto.DtoReserva;
import com.ceiba.usuario.puerto.dao.DaoReserva;

public class ServicioConsultarReserva {

	private final DaoReserva daoReserva;

    public ServicioConsultarReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long id) {
    	DtoReserva dtoReserva = this.daoReserva.consultar(id);
    	if(dtoReserva == null){
    		throw new ExcepcionSinDatos("Registro no encontrado");
    	}
    	return dtoReserva;
    }

}
