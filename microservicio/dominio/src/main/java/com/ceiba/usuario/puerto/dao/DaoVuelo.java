package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoVuelo;

import java.util.List;

public interface DaoVuelo {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoVuelo> listar();
}
