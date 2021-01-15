package com.ceiba.reserva.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoReserva;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoReserva;

@Component
public class DaoReservaMysql implements DaoReserva {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="reserva", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="reserva", value="consultar")
    private static String sqlConsultar;

    public DaoReservaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoReserva> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoReserva());
    }
    
    @Override
    public DtoReserva consultar(Long id) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        try {
        	return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultar,paramSource, new MapeoReserva());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
