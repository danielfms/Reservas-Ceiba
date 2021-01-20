package com.ceiba.vuelo.consulta;

import java.time.LocalDateTime;
import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoVuelo;

import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoVuelo;

@Component
public class ManejadorListarVuelo {

    private final DaoVuelo daoVuelo;

    public ManejadorListarVuelo(DaoVuelo daoVuelo){
        this.daoVuelo = daoVuelo;
    }

    public List<DtoVuelo> ejecutar(){ return this.daoVuelo.listar(); }
    
    public List<DtoVuelo> ejecutar(String ciudadOrigen, String ciudadDestino, String fecha){ return this.daoVuelo.listarPorCiudadOrigenYCiudadDestinoYFechaYPasajeros(ciudadOrigen, ciudadDestino, fecha); }
}
