package com.ceiba.vuelo.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoVuelo;

import org.springframework.jdbc.core.RowMapper;

public class MapeoVuelo implements RowMapper<DtoVuelo>, MapperResult {

    @Override
    public DtoVuelo mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idDestino = resultSet.getLong("id_destino");
        Long idAvion = resultSet.getLong("id_avion");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha");
        Integer duracion = resultSet.getInt("duracion");

        return new DtoVuelo(id, idDestino, idAvion, fecha, duracion);
    }
    
}