package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.comando.ComandoReserva;
public class ComandoReservaTestDataBuilder {

	private Long id;
    private Long idVuelo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer pasajeros;
    private Integer valorTotal;
    private Boolean activa;
    private String token;

    public ComandoReservaTestDataBuilder() {
    	id = 1L;
        idVuelo = 1L;
        tipoIdentificacion = "CC";
        numeroIdentificacion = "12345678913";
        pasajeros = 1;
        valorTotal = 10000;
        activa = true;
        token = "TOKEN";
    }

    public ComandoReservaTestDataBuilder conToken(String token) {
        this.token = token;
        return this;
    }
    
    public ComandoReservaTestDataBuilder conTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
        return this;
    }
    
    public ComandoReservaTestDataBuilder conNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
        return this;
    }

    public ComandoReserva build() {
        return new ComandoReserva(id, idVuelo, tipoIdentificacion, numeroIdentificacion, pasajeros, valorTotal, activa, token);
    }
}
