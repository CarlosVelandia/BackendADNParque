package com.ceiba.tiquete.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.parque.modelo.dto.DtoParque;
import com.ceiba.tiquete.modelo.dto.DtoTiquete;

import javax.swing.tree.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MapeoTiquete implements RowMapper<DtoTiquete>, MapperResult {
    @Override
    public DtoTiquete mapRow(ResultSet resultSet, int rowNum) throws SQLException {


        Long id = resultSet.getLong("id");
        LocalDate fechaCompra= extraerLocalDate(resultSet, "fecha_compra");
        double valor=resultSet.getDouble("valor");

        Long idUsuario = resultSet.getLong("id_usuario");
        /*
        String nombre = resultSet.getString("nombre");
        String clave = resultSet.getString("clave");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");
        */
        Long idParque = resultSet.getLong("id_parque");
        /*
        String nombre = resultSet.getString("nombre");
        String codigo = resultSet.getString("codigo");
        String direccion = resultSet.getString("direccion");
        String telefono = resultSet.getString("telefono");

         */

        return new DtoTiquete(id,fechaCompra,idUsuario,idParque,valor)
        //return new DtoParque(id,nombre,codigo,direccion,telefono);
}
