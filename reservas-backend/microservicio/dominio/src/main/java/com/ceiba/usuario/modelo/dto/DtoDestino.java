package com.ceiba.usuario.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoDestino {
    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Integer valorBase;

}
