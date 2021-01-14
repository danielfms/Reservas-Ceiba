package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoVuelo {
    private Long id;
    private Long idDestino;
    private Long idAvion;
    private LocalDateTime fecha;
    private Integer duracion;


}
