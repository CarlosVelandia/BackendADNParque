package com.ceiba.tiquete.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioActualizarTiquete {


    private static final String EL_TIQUETE_NO_EXISTE = "El tiquete no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";
    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";

    private final RepositorioTiquete repositorioTiquete;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioParque repositorioParque;
    private final ValidadorTiquete validadorTiquete;

    public ServicioActualizarTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioTiquete = repositorioTiquete;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
        this.validadorTiquete = new ValidadorTiquete(this.repositorioTiquete, this.repositorioUsuario, this.repositorioParque);

    }

    public void ejecutar(Tiquete tiquete) {
        validarExistenciaTiquete(tiquete);
        validarExistenciaUsuario(tiquete);
        validarExistenciaParque(tiquete);
        validadorTiquete.validarDiaLunes(tiquete.getFechaCompra());
        validadorTiquete.maximoTiquetesPersona(tiquete);
        validadorTiquete.maximoTiquetesParque(tiquete);
        validadorTiquete.validarFinDeSemana(tiquete);
        this.repositorioTiquete.actualizar(tiquete);
    }

    private void validarExistenciaTiquete(Tiquete tiquete) {
        boolean existe = this.repositorioTiquete.existeId(tiquete.getId());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_TIQUETE_NO_EXISTE);
        }
    }

    private void validarExistenciaUsuario(Tiquete tiquete) {
        boolean existe = this.repositorioUsuario.existeId(tiquete.getIdUsuario());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarExistenciaParque(Tiquete tiquete) {
        boolean existe = this.repositorioParque.existeId(tiquete.getIdParque());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PARQUE_NO_EXISTE);
        }
    }
}
