package com.ceiba.reserva.servicio;

import com.ceiba.usuario.modelo.entidad.Reserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.servicio.testdatabuilder.DtoVueloTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioCrearReservaTest {
	
	

    @Test
    public void validarValorTotalPositivoTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conValorTotal(-5);
        // act - assert
        BasePrueba.assertThrows(() -> reservaTestDataBuilder.build(), ExcepcionValorInvalido.class, "El valor total debe ser positivo");
    }

    @Test
    public void validarIdentificacionNoTengaReservaActivaTest() {
        // arrange
        Reserva reserva = new ReservaTestDataBuilder().build();
        DaoVuelo daoVuelo = Mockito.mock(DaoVuelo.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.anyString())).thenReturn(true);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoVuelo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"El usuario ya tiene una reserva activa");
    }
    
    @Test
    public void validarValorTotalFinDeSemanaTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conValorTotal(10);
        DtoVueloTestDataBuilder vueloTestDataBuilder = new DtoVueloTestDataBuilder().conFecha(LocalDateTime.of(2021, 1, 16, 0, 0));
        ServicioCrearReserva servicioCrearReserva= Mockito.mock(ServicioCrearReserva.class);
        
        // act 
        Reserva reserva =  reservaTestDataBuilder.build();
        servicioCrearReserva.validarValorFinDeSemana(reserva, vueloTestDataBuilder.build());
        
        //assert
        assertTrue("El valor total debe tener una recargo de 10%", !reserva.getValorTotal().equals(11));
    }
    
    @Test
    public void validarDescuentoPorDuracionNoFinDeSemanaTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conValorTotal(20);
        DtoVueloTestDataBuilder vueloTestDataBuilder = new DtoVueloTestDataBuilder()
        		.conFecha(LocalDateTime.of(2021, 1, 13, 0, 0))
        		.conDuracion(120);
        ServicioCrearReserva servicioCrearReserva= Mockito.mock(ServicioCrearReserva.class);
        
        // act 
        Reserva reserva =  reservaTestDataBuilder.build();
        servicioCrearReserva.validarDuracionVuelo(reserva, vueloTestDataBuilder.build());
        
        //assert
        assertTrue("El valor total debe tener un descuento de 5%", !reserva.getValorTotal().equals(19));
    }
}
