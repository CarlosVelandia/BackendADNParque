package com.ceiba.parque.servicio;

import com.ceiba.parque.excepcion.ExcepcionParque;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioActualizarParque {

    private static final String EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El parque no existe en el sistema";
    private static final String EL_CODIGO_PARQUE_NO_EXISTE_EN_EL_SISTEMA = "El codigo del parque no existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioActualizarParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public void ejecutar(Parque parque) {
        validarExistenciaPreviaParque(parque);
        validarExistenciaPreviaCodigo(parque);
        this.repositorioParque.actualizar(parque);
    }

    private void validarExistenciaPreviaParque(Parque parque) {
        boolean existe = this.repositorioParque.existeId(parque.getId());
        if (!existe) {
            throw new ExcepcionParque(EL_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaCodigo(Parque parque) {
        boolean existe = this.repositorioParque.existeCodigo(parque.getCodigo());
        if (existe) {
            throw new ExcepcionParque(EL_CODIGO_PARQUE_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
