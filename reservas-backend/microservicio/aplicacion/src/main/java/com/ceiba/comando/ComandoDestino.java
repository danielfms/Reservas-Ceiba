package com.ceiba.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoDestino{

    private Long id;
    private String ciudadOrigen;
    private String ciudadDestino;
    private Integer valorBase;
}
