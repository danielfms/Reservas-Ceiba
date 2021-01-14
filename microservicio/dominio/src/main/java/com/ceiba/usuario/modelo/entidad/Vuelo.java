package com.ceiba.usuario.modelo.entidad;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.DayOfWeek;
import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class Vuelo {


    private Long id;
    private Long idDestino;
    private Long idAvion;
    private LocalDateTime fecha;
    private Integer duracion;
    
    public boolean elVueloEsFinDeSemana(LocalDateTime fecha){
    	DayOfWeek d = fecha.getDayOfWeek();
    	return (d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY);
    }

}
