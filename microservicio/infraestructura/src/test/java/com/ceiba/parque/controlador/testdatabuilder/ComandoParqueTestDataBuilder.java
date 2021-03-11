package com.ceiba.parque.controlador.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

public class ComandoParqueTestDataBuilder {

    private Long id;
    private String nombre;
    private String cedula;

    public ComandoParqueTestDataBuilder() {
        this.id = 0l;
        this.nombre = "Carlos Velandia";
        this.cedula = "1115081333";
    }

    public ComandoParqueTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoParqueTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoParqueTestDataBuilder conCedula(String cedula) {
        this.cedula = cedula;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id, nombre, cedula);
    }
}
