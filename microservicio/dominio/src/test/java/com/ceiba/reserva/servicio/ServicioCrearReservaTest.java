package com.ceiba.reserva.servicio;

import com.ceiba.usuario.modelo.entidad.Reserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.reserva.servicio.testdatabuilder.ReservaTestDataBuilder;
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
        Mockito.when(repositorioReserva.existe(Mockito.anyString(), Mockito.anyString())).thenReturn(false);
        ServicioCrearReserva servicioCrearReserva = new ServicioCrearReserva(repositorioReserva, daoVuelo);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearReserva.ejecutar(reserva), ExcepcionDuplicidad.class,"El usuario ya tiene una reserva activa");
    }
}
