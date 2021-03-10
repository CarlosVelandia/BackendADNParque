package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String cedula;
    ;

    public ComandoUsuarioTestDataBuilder() {
        id = 0l;
        nombre = "Carlos Velandia";
        cedula = "1115081333";
    }

    public ComandoUsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuarioTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id, nombre, cedula);
    }
}
