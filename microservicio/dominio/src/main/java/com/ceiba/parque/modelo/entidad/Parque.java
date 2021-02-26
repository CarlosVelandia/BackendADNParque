package com.ceiba.parque.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Parque {

    private static final String SE_DEBE_INGRESAR_EL_TELEFONO = "Se debe ingresar el telefono del parque";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PARQUE = "Se debe ingresar el nombre de usuario";
    private static final String SE_DEBE_INGRESAR_EL_CODIGO_DEL_PARQUE = "Se debe ingresar el codigo del parque";


    private Long id;
    private String nombre;
    private String codigo;
    private String direccion;
    private String telefono;

    public Parque(Long id,String nombre,String codigo,String direccion,String telefono) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DEL_PARQUE);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_EL_CODIGO_DEL_PARQUE);
        validarObligatorio(direccion, SE_DEBE_INGRESAR_LA_DIRECCION);
        validarObligatorio(telefono, SE_DEBE_INGRESAR_EL_TELEFONO);

        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.direccion = direccion;
        this.telefono = telefono;
    }

}
