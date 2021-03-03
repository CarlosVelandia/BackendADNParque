package com.ceiba.parque.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioCrearParque {

    private static final String EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioCrearParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public Long ejecutar(Parque parque) {
        validarExistenciaPrevia(parque);
        return this.repositorioParque.crear(parque);
    }

    private void validarExistenciaPrevia(Parque parque) {
        boolean existe = this.repositorioParque.existe(parque.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
