package com.ceiba.destino.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoDestino;
import org.springframework.jdbc.core.RowMapper;

public class MapeoDestino implements RowMapper<DtoDestino>, MapperResult {

    @Override
    public DtoDestino mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String ciudadOrigen = resultSet.getString("ciudad_origen");
        String ciudadDestino = resultSet.getString("ciudad_destino");
        Integer valorBase = resultSet.getInt("valor_base");

        return new DtoDestino(id, ciudadOrigen, ciudadDestino, valorBase);
    }

}
