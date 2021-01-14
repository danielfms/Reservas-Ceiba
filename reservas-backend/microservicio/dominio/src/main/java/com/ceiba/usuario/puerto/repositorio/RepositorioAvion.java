package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Avion;

public interface RepositorioAvion {
    /**
     * Permite crear un avion
     * @param usuario
     * @return el id generado
     */
    Long crear(Avion entidad);

    /**
     * Permite actualizar un avion
     * @param usuario
     */
    void actualizar(Avion entidad);

    /**
     * Permite eliminar un avion
     * @param id
     */
    void eliminar(Long id);

}
