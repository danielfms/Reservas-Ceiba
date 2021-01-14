package com.ceiba.usuario.puerto.repositorio;

import com.ceiba.usuario.modelo.entidad.Destino;

public interface RepositorioDestino {
    /**
     * Permite crear un avion
     * @param usuario
     * @return el id generado
     */
    Long crear(Destino entidad);

    /**
     * Permite actualizar un avion
     * @param usuario
     */
    void actualizar(Destino entidad);

    /**
     * Permite eliminar un avion
     * @param id
     */
    void eliminar(Long id);

}
