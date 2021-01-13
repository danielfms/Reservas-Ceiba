package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoDestino;

import java.util.List;

public interface DaoDestino {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoDestino> listar();
    
    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    DtoDestino consultar(Long id);
}
