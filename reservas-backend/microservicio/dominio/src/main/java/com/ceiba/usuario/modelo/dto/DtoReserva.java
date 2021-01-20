package com.ceiba.usuario.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class DtoReserva {
    private Long id;
    private Long idVuelo;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private Integer pasajeros;
    private Integer valorTotal;
    private Boolean activo;
    private String token;

}
