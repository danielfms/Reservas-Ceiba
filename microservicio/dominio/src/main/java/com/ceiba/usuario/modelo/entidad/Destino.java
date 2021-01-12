package com.ceiba.usuario.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Destino {

    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Integer valorBase;


}
