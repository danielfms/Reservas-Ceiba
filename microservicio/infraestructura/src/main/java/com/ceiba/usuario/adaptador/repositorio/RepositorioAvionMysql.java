package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Avion;
import com.ceiba.usuario.puerto.repositorio.RepositorioAvion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioAvionMysql implements RepositorioAvion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="avion", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="avion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="avion", value="eliminar")
    private static String sqlEliminar;


    public RepositorioAvionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Avion avion) {
        return this.customNamedParameterJdbcTemplate.crear(avion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Avion avion) {
        this.customNamedParameterJdbcTemplate.actualizar(avion, sqlActualizar);
    }

}
