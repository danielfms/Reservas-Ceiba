package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoReserva;

import java.util.List;

public interface DaoReserva {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoReserva> listar();
    
    DtoReserva consultar(Long id);
}
