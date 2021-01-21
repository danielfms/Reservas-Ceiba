package com.ceiba.vuelo.adaptador.dao;

import java.util.List;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.puerto.dao.DaoVuelo;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.usuario.modelo.dto.DtoVuelo;

@Component
public class DaoVueloMysql implements DaoVuelo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="vuelo", value="listar")
    private static String sqlListar;
    
    @SqlStatement(namespace="vuelo", value="listarConFiltros")
    private static String sqlListarConFiltros;
    
    @SqlStatement(namespace="vuelo", value="consultar")
    private static String sqlConsultar;

    public DaoVueloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoVuelo> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoVuelo());
    }
    
    @Override
    public DtoVuelo consultar(Long id) {
    	MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlConsultar,paramSource, new MapeoVuelo());
    }

	@Override
	public List<DtoVuelo> listarPorCiudadOrigenYCiudadDestinoYFechaYPasajeros(String ciudadOrigen,
			String ciudadDestino, String fecha) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("ciudad_origen", ciudadOrigen);
        paramSource.addValue("ciudad_destino", ciudadDestino);
        paramSource.addValue("fecha", fecha);
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarConFiltros, paramSource, new MapeoVuelo());
	}
    
}
