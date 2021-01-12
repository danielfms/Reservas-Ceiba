package com.ceiba.usuario.puerto.repositorio;


import com.ceiba.usuario.modelo.entidad.Vuelo;

public interface RepositorioVuelo {
    /**
     * Permite crear un avion
     * @param usuario
     * @return el id generado
     */
    Long crear(Vuelo entidad);

    /**
     * Permite actualizar un avion
     * @param usuario
     */
    void actualizar(Vuelo entidad);

    /**
     * Permite eliminar un avion
     * @param id
     */
    void eliminar(Long id);

}
