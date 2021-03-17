package com.ceiba.usuario.servicio;

import com.ceiba.usuario.excepcion.ExcepcionUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;


public class ServicioCrearUsuario {

    private static final String LA_CEDULA_YA_EXISTE = "El usuario ya existe en el sistema con la cedula";
    private static final String EL_USUARIO_YA_EXISTE = "EL usuario ya existe en el sistema";

    private final RepositorioUsuario repositorioUsuario;

    public ServicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Long ejecutar(Usuario usuario) {
        validarExistenciaUsuarioPreviaCedula(usuario);
        validarExistenciaUsuarioId(usuario);
        return this.repositorioUsuario.crear(usuario);
    }

    private void validarExistenciaUsuarioPreviaCedula(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existeCedula(usuario.getCedula());
        if (existe) {
            throw new ExcepcionUsuario(LA_CEDULA_YA_EXISTE);
        }
    }

    private void validarExistenciaUsuarioId(Usuario usuario) {
        boolean existe = this.repositorioUsuario.existeId(usuario.getId());
        if (existe) {
            throw new ExcepcionUsuario(EL_USUARIO_YA_EXISTE);
        }
    }
}
