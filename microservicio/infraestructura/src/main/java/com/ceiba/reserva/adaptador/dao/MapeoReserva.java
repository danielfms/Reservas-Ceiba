package com.ceiba.reserva.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoReserva;
import org.springframework.jdbc.core.RowMapper;

public class MapeoReserva implements RowMapper<DtoReserva>, MapperResult {

    @Override
    public DtoReserva mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idVuelo = resultSet.getLong("id_vuelo");
        String tipoIdentificacion = resultSet.getString("tipo_identificacion");
        String numeroIdentificacion = resultSet.getString("numero_identificacion");
        Integer pasajeros = resultSet.getInt("pasajeros");
        Integer valorTotal = resultSet.getInt("valor_total");
        Boolean activo = resultSet.getBoolean("activo");
        String token = resultSet.getString("token");
        LocalDateTime fechaCreacion = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoReserva(id, idVuelo, tipoIdentificacion, numeroIdentificacion, pasajeros, valorTotal, activo, token, fechaCreacion);
    }
}
