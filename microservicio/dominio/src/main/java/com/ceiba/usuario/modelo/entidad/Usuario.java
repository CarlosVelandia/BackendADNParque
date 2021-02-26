package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static com.ceiba.dominio.ValidadorArgumento.validarLongitud;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_CREACION = "Se debe ingresar la fecha de creación";
    private static final String LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A = "La clave debe tener una longitud mayor o igual a %s";
    private static final String SE_DEBE_INGRESAR_LA_CLAVE = "Se debe ingresar la clave";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";

    private static final int LONGITUD_MINIMA_CLAVE = 4;

    private Long id;
    private String nombre;
    private String clave;
    private LocalDate fechaCreacion;

    public Usuario(Long id,String nombre, String clave,String fechaCreacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(clave, SE_DEBE_INGRESAR_LA_CLAVE);
        validarLongitud(clave, LONGITUD_MINIMA_CLAVE, String.format(LA_CLAVE_DEBE_TENER_UNA_LONGITUD_MAYOR_O_IGUAL_A,LONGITUD_MINIMA_CLAVE));
        validarObligatorio(fechaCreacion, SE_DEBE_INGRESAR_LA_FECHA_CREACION);

        DateTimeFormatter formatter= DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.fechaCreacion = LocalDate.parse(fechaCreacion, formatter);
    }
}
