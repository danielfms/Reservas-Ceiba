package com.ceiba.reserva.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Reserva;

import java.time.LocalDateTime;

public class ReservaTestDataBuilder {

	private Long id;
    private Long idVuelo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer pasajeros;
    private Integer valorTotal;
    private Boolean activa;
    private String token;
    private LocalDateTime fechaCreacion;

    public ReservaTestDataBuilder() {
    	id = 1L;
        idVuelo = 1L;
        tipoIdentificacion = "CC";
        numeroIdentificacion = "123";
        pasajeros = 1;
        valorTotal = 10000;
        activa = true;
        token = "TOKEN12345";
        fechaCreacion = LocalDateTime.now();
    }

    public ReservaTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }

    public ReservaTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }
    
    public ReservaTestDataBuilder conValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public Reserva build() {
        return new Reserva(
        		id,
        		idVuelo,
        		tipoIdentificacion,
        		numeroIdentificacion,
        		pasajeros,
        		valorTotal,
        		activa,
        		token,
        		fechaCreacion);
    }
}
