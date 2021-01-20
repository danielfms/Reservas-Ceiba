package com.ceiba.reserva.consulta;

import java.util.List;

import com.ceiba.usuario.puerto.dao.DaoReserva;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoReserva;

@Component
public class ManejadorListarReserva {

    private final DaoReserva daoReserva;

    public ManejadorListarReserva(DaoReserva daoReserva){
        this.daoReserva = daoReserva;
    }

    public List<DtoReserva> ejecutar(){ return this.daoReserva.listar(); }
}
