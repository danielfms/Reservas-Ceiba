package com.ceiba.usuario.puerto.repositorio;


import com.ceiba.usuario.modelo.entidad.Reserva;

public interface RepositorioReserva {
    /**
     * Permite crear un avion
     * @param usuario
     * @return el id generado
     */
    Long crear(Reserva entidad);

    /**
     * Permite actualizar un avion
     * @param usuario
     */
    void actualizar(Reserva entidad);

    /**
     * Permite eliminar un avion
     * @param id
     */
    void eliminar(Long id);
    
	/**
	 * Permite validar si existe un usuario con un nombre
	 * @param nombre
	 * @return si existe o no
	 */
	boolean existe(String tipoIdentificacion, String numeroIdentificacion);
    
}
