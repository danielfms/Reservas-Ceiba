package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.dto.DtoVuelo;

import java.time.LocalDateTime;

public class DtoVueloTestDataBuilder {

	private Long id;
	private Long idDestino;
	private Long idAvion;
	private LocalDateTime fecha;
	private Integer duracion;

    public DtoVueloTestDataBuilder() {
    	id = 1L;
        idDestino = 1L;
        idAvion = 1L;
        fecha = LocalDateTime.now();
        duracion = 90;
    }

    public DtoVueloTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }
    
    public DtoVueloTestDataBuilder conDuracion(Integer duracion) {
        this.duracion = duracion;
        return this;
    }

    public DtoVuelo build() {
        return new DtoVuelo(id, idDestino, idAvion, fecha, duracion);
    }
}
