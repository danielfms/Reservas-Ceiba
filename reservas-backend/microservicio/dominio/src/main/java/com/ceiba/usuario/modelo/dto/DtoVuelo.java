package com.ceiba.usuario.modelo.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DtoVuelo {
    private Long id;
    private Long idDestino;
    private Long idAvion;
    private LocalDateTime fecha;
    private Integer duracion;
    private String ciudadOrigen;
    private String ciudadDestino;
    private String matriculaAvion;
    
    public DtoVuelo(Long id, Long idDestino, Long idAvion, LocalDateTime fecha, Integer duracion){
    	this.id = id;
    	this.idDestino = idDestino;
    	this.idAvion = idAvion;
    	this.fecha = fecha;
    	this.duracion = duracion;
    }

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public void setCiudadDestino(String ciudadDestino) {
		this.ciudadDestino = ciudadDestino;
	}

	public void setMatriculaAvion(String matriculaAvion) {
		this.matriculaAvion = matriculaAvion;
	}
}
