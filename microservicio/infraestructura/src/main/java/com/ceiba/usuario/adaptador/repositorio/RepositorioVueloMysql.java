package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Vuelo;
import com.ceiba.usuario.puerto.repositorio.RepositorioVuelo;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVueloMysql implements RepositorioVuelo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="vuelo", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="vuelo", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="vuelo", value="eliminar")
    private static String sqlEliminar;

    public RepositorioVueloMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Vuelo vuelo) {
        return this.customNamedParameterJdbcTemplate.crear(vuelo, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }


    @Override
    public void actualizar(Vuelo vuelo) {
        this.customNamedParameterJdbcTemplate.actualizar(vuelo, sqlActualizar);
    }

}
