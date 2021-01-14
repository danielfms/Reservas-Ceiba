package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.usuario.modelo.entidad.Destino;
import com.ceiba.usuario.puerto.repositorio.RepositorioDestino;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioDestinoMysql implements RepositorioDestino {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="destino", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="destino", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="destino", value="eliminar")
    private static String sqlEliminar;

    public RepositorioDestinoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Destino destino) {
        return this.customNamedParameterJdbcTemplate.crear(destino, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Destino destino) {
        this.customNamedParameterJdbcTemplate.actualizar(destino, sqlActualizar);
    }

}
