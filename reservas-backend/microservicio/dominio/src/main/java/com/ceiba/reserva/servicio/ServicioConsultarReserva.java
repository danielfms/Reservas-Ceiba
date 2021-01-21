package com.ceiba.reserva.servicio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.usuario.modelo.dto.DtoReserva;
import com.ceiba.usuario.puerto.dao.DaoReserva;

public class ServicioConsultarReserva {

	private static final Logger LOGGER_ERROR = LoggerFactory.getLogger(ServicioConsultarReserva.class);
	private final DaoReserva daoReserva;

    public ServicioConsultarReserva(DaoReserva daoReserva) {
        this.daoReserva = daoReserva;
    }

    public DtoReserva ejecutar(Long id) {
    	DtoReserva dtoReserva = this.daoReserva.consultar(id);
    	if(dtoReserva == null){
    		LOGGER_ERROR.error("Registro no encontrado");
    		throw new ExcepcionSinDatos("Registro no encontrado");
    	}
    	return dtoReserva;
    }

}
