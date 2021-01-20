package com.ceiba.reserva.servicio;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.dto.DtoVuelo;
import com.ceiba.usuario.modelo.entidad.Reserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;


public class ServicioCrearReserva{
	


	private static final String EL_USUARIO_YA_TIENE_UNA_RESERVA_ACTIVA_EN_EL_SISTEMA = "El usuario ya tiene una reserva activa en el sistema";
	
	private final RepositorioReserva repositorioReserva;
	private final DaoVuelo daoVuelo;
	

    public ServicioCrearReserva(RepositorioReserva repositorioReserva, DaoVuelo daoVuelo) {
        this.repositorioReserva = repositorioReserva;
        this.daoVuelo = daoVuelo;
    }

    public Long ejecutar(Reserva reserva) {
    	DtoVuelo vuelo = daoVuelo.consultar(reserva.getIdVuelo());
    	validarExistenciaReservaActiva(reserva);
    	calcularValorFinDeSemana(reserva, vuelo);
    	calcularValorDuracionVuelo(reserva, vuelo);
        return this.repositorioReserva.crear(reserva);
    }
    
    private void validarExistenciaReservaActiva(Reserva reserva) {
        boolean existe = this.repositorioReserva.existe(reserva.getTipoIdentificacion(), reserva.getNumeroIdentificacion());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_TIENE_UNA_RESERVA_ACTIVA_EN_EL_SISTEMA);
        }
    }
    
    private void calcularValorFinDeSemana(Reserva reserva, DtoVuelo vuelo) {
        if(esFinDeSemana(vuelo.getFecha())){
        	reserva.calcularValorPorFinDeSemana();
        }
    }
    
    private void calcularValorDuracionVuelo(Reserva reserva, DtoVuelo vuelo) {
        if(vuelo.getDuracion().compareTo(60) > 0 && !esFinDeSemana(vuelo.getFecha())){
        	reserva.calcularValorPorDuracionNoFinDeSemana();
        }
    }
    
    
    private boolean esFinDeSemana(LocalDateTime fecha){
    	DayOfWeek d = fecha.getDayOfWeek();
    	return (d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY);
    }
}
