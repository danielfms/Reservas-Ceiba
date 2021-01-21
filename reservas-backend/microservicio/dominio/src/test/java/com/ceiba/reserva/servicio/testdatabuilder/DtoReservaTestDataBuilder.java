package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.dto.DtoReserva;
import com.ceiba.usuario.modelo.entidad.Reserva;

public class DtoReservaTestDataBuilder {

	private Long id;
    private Long idVuelo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer pasajeros;
    private Integer valorTotal;
    private Boolean activa;
    private String token;

    public DtoReservaTestDataBuilder() {
    	id = 1L;
        idVuelo = 1L;
        tipoIdentificacion = "CC";
        numeroIdentificacion = "123";
        pasajeros = 1;
        valorTotal = 10000;
        activa = true;
        token = "TOKEN";
    }

    public DtoReservaTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public DtoReservaTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }
    
    public DtoReservaTestDataBuilder conValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public DtoReserva build() {
        return new DtoReserva(
        		id,
        		idVuelo,
        		tipoIdentificacion,
        		numeroIdentificacion,
        		pasajeros,
        		valorTotal,
        		activa,
        		token);
    }
}
