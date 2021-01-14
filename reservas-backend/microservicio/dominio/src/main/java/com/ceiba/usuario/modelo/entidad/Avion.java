package com.ceiba.usuario.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Avion {

    private Long id;
    private String matricula;
    private Integer pasajeros;

}
