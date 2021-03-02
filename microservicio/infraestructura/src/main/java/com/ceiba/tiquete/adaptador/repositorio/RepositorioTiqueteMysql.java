package com.ceiba.tiquete.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioTiqueteMysql implements RepositorioTiquete {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "tiquete", value = "crear")
    private static String sqlCrear;

    @SqlStatement(namespace="tiquete", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="tiquete", value="eliminar")
    private static String sqlEliminar;

    public RepositorioTiqueteMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate){
        this.customNamedParameterJdbcTemplate=customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Tiquete tiquete){
        return this.customNamedParameterJdbcTemplate.crear(tiquete, sqlCrear);
    }

    @Override
    public void eliminar(Long id){
        MapSqlParameterSource paramSource=new MapSqlParameterSource();
        paramSource.addValue("id",id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public void actualizar(Tiquete tiquete){
        this.customNamedParameterJdbcTemplate.actualizar(tiquete, sqlActualizar);
    }
}
