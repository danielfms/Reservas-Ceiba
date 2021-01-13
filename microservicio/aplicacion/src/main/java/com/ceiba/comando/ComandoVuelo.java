package com.ceiba.comando;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoVuelo{

    private Long id;
    private Long idDestino;
    private Long idAvion;
    private LocalDateTime fecha;
    private Integer duracion;
}
