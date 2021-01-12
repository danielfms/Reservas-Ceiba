package com.ceiba.usuario.puerto.dao;

import com.ceiba.usuario.modelo.dto.DtoAvion;

import java.util.List;

public interface DaoAvion {

    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoAvion> listar();
}
