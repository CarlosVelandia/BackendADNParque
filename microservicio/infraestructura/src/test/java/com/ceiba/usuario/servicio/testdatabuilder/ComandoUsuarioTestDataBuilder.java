package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoUsuarioTestDataBuilder {

    private Long id;
    private String nombre;
    private String cedula;

    public ComandoUsuarioTestDataBuilder() {
        this.id = 0l;
        this.nombre = "Carlos Velandia";
        this.cedula = "1115081333";
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
