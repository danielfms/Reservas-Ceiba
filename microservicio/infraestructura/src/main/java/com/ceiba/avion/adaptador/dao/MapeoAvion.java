package com.ceiba.avion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoAvion;
import org.springframework.jdbc.core.RowMapper;

public class MapeoAvion implements RowMapper<DtoAvion>, MapperResult {

    @Override
    public DtoAvion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String matricula = resultSet.getString("matricula");
        Integer pasajeros = resultSet.getInt("pasajeros");
        return new DtoAvion(id,matricula,pasajeros);
    }

}

