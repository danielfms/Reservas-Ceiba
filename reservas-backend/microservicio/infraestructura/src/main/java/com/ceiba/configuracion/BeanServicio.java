package com.ceiba.configuracion;

import com.ceiba.avion.servicio.ServicioActualizarAvion;
import com.ceiba.avion.servicio.ServicioCrearAvion;
import com.ceiba.avion.servicio.ServicioEliminarAvion;
import com.ceiba.destino.servicio.ServicioActualizarDestino;
import com.ceiba.destino.servicio.ServicioCrearDestino;
import com.ceiba.destino.servicio.ServicioEliminarDestino;
import com.ceiba.reserva.servicio.ServicioActualizarReserva;
import com.ceiba.reserva.servicio.ServicioCrearReserva;
import com.ceiba.reserva.servicio.ServicioEliminarReserva;
import com.ceiba.usuario.puerto.dao.DaoVuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioAvion;
import com.ceiba.usuario.puerto.repositorio.RepositorioDestino;
import com.ceiba.usuario.puerto.repositorio.RepositorioReserva;
import com.ceiba.usuario.puerto.repositorio.RepositorioVuelo;
import com.ceiba.vuelo.servicio.ServicioActualizarVuelo;
import com.ceiba.vuelo.servicio.ServicioCrearVuelo;
import com.ceiba.vuelo.servicio.ServicioEliminarVuelo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {
    
    @Bean
    public ServicioCrearAvion servicioCrearAvion(RepositorioAvion repositorioAvion) {
    	return new ServicioCrearAvion(repositorioAvion);
    }

    @Bean
    public ServicioEliminarAvion servicioEliminarAvion(RepositorioAvion repositorioAvion) {
    	return new ServicioEliminarAvion(repositorioAvion);
    }

    @Bean
    public ServicioActualizarAvion servicioActualizarAvion(RepositorioAvion repositorioAvion) {
    	return new ServicioActualizarAvion(repositorioAvion);
    }
    
    @Bean
    public ServicioCrearDestino servicioCrearDestino(RepositorioDestino repositorioDestino) {
    	return new ServicioCrearDestino(repositorioDestino);
    }

    @Bean
    public ServicioEliminarDestino servicioEliminarDestino(RepositorioDestino repositorioDestino) {
    	return new ServicioEliminarDestino(repositorioDestino);
    }

    @Bean
    public ServicioActualizarDestino servicioActualizarDestino(RepositorioDestino repositorioDestino) {
    	return new ServicioActualizarDestino(repositorioDestino);
    }
    
    @Bean
    public ServicioCrearReserva servicioCrearReserva(RepositorioReserva repositorioReserva, DaoVuelo daoVuelo) {
    	return new ServicioCrearReserva(repositorioReserva, daoVuelo);
    }

    @Bean
    public ServicioEliminarReserva servicioEliminarReserva(RepositorioReserva repositorioReserva) {
    	return new ServicioEliminarReserva(repositorioReserva);
    }

    @Bean
    public ServicioActualizarReserva servicioActualizarReserva(RepositorioReserva repositorioReserva) {
    	return new ServicioActualizarReserva(repositorioReserva);
    }
    
    @Bean
    public ServicioCrearVuelo servicioCrearVuelo(RepositorioVuelo repositorioVuelo) {
    	return new ServicioCrearVuelo(repositorioVuelo);
    }

    @Bean
    public ServicioEliminarVuelo servicioEliminarVuelo(RepositorioVuelo repositorioVuelo) {
    	return new ServicioEliminarVuelo(repositorioVuelo);
    }

    @Bean
    public ServicioActualizarVuelo servicioActualizarVuelo(RepositorioVuelo repositorioVuelo) {
    	return new ServicioActualizarVuelo(repositorioVuelo);
    }

}
