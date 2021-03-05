package com.ceiba.parque.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioActualizarParque {

    private static final String EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";
    private static final String EL_CODIGO_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El codigo del parque no existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioActualizarParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public void ejecutar(Parque parque) {
        validarExistenciaPreviaParque(parque);
        validarExistenciaPreviaCedula(parque);
        this.repositorioParque.actualizar(parque);
    }

    private void validarExistenciaPreviaParque(Parque parque) {
        boolean existe = this.repositorioParque.existeExcluyendoId(parque.getId(), parque.getNombre());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaCedula(Parque parque) {
        boolean existe = this.repositorioParque.existeCodigo(parque.getCodigo());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_CODIGO_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
