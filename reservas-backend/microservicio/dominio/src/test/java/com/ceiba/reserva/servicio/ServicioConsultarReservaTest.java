package com.ceiba.reserva.servicio;

import com.ceiba.usuario.modelo.dto.DtoReserva;
import com.ceiba.usuario.modelo.entidad.Reserva;
import com.ceiba.usuario.puerto.dao.DaoReserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionSinDatos;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.servicio.testdatabuilder.DtoReservaTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.DtoVueloTestDataBuilder;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;

public class ServicioConsultarReservaTest {
	
    @Test
    public void validarConsultarDaoReservaNoEncontradoTest() {
        // arrange
    	Long id = 1L;
        DaoReserva daoReserva = Mockito.mock(DaoReserva.class);
        Mockito.when(daoReserva.consultar(Mockito.anyLong())).thenReturn(null);
        ServicioConsultarReserva servicioConsultarReserva = new ServicioConsultarReserva(daoReserva);
        // act - assert
        BasePrueba.assertThrows(() -> {DtoReserva r = servicioConsultarReserva.ejecutar(id);}, ExcepcionSinDatos.class,"Registro no encontrado");
    }
    
    @Test
    public void validarConsultarDaoReservaEncontradoTest() {
        // arrange
    	Long id = 1L;
    	DtoReserva reserva = new DtoReservaTestDataBuilder().build();
        DaoReserva daoReserva = Mockito.mock(DaoReserva.class);
        Mockito.when(daoReserva.consultar(Mockito.anyLong())).thenReturn(reserva);
        ServicioConsultarReserva servicioConsultarReserva = new ServicioConsultarReserva(daoReserva);
        // act - assert
        DtoReserva consultado = servicioConsultarReserva.ejecutar(id);
        assertEquals(reserva, consultado);
    }
}
