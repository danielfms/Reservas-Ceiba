package com.ceiba.reserva.servicio;

import com.ceiba.usuario.modelo.entidad.Reserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.servicio.testdatabuilder.DtoVueloTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

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
        DaoVuelo daoVuelo = Mockito.mock(DaoVuelo.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(daoVuelo.consultar(Mockito.anyLong())).thenReturn(vueloTestDataBuilder.build());
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoVuelo);
        // act 
        Reserva reserva = reservaTestDataBuilder.build();
        servicioCrearReserva.ejecutar(reserva);
        
        //assert
        assertEquals(11, reserva.getValorTotal().intValue());
    }
    
    @Test
    public void validarDescuentoPorDuracionNoFinDeSemanaTest() {
        // arrange
        ReservaTestDataBuilder reservaTestDataBuilder = new ReservaTestDataBuilder().conValorTotal(20);
        DtoVueloTestDataBuilder vueloTestDataBuilder = new DtoVueloTestDataBuilder()
        		.conFecha(LocalDateTime.of(2021, 1, 13, 0, 0))
        		.conDuracion(120);
        DaoVuelo daoVuelo = Mockito.mock(DaoVuelo.class);
        RepositorioReserva repositorioReserva = Mockito.mock(RepositorioReserva.class);
        Mockito.when(daoVuelo.consultar(Mockito.anyLong())).thenReturn(vueloTestDataBuilder.build());
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoVuelo);
        // act 
        Reserva reserva = reservaTestDataBuilder.build();
        servicioCrearReserva.ejecutar(reserva);
        
        //assert
        assertEquals(19, reserva.getValorTotal().intValue());
    }
}
