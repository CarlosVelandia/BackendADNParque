package com.ceiba.parque.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioCrearParque {

    private static final String EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";
    private static final String EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA= "El nombre del parque ya existe en el sistema";
    private static final String EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA= "El codigo del parque ya existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioCrearParque(RepositorioParque repositorioParque) {
        this.repositorioParque = repositorioParque;
    }

    public Long ejecutar(Parque parque) {
        validarExistenciaParquePrevia(parque);
        validarExistenciaParquePreviaCodigo(parque);
        validarExistenciaParqueId(parque);
        return this.repositorioParque.crear(parque);
    }

    private void validarExistenciaParquePrevia(Parque parque) {
        boolean existe = this.repositorioParque.existe(parque.getNombre());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_NOMBRE_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
    private void validarExistenciaParquePreviaCodigo(Parque parque) {
        boolean existe = this.repositorioParque.existeCodigo(parque.getCodigo());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_CODIGO_DEL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaParqueId(Parque parque){
        boolean existe = this.repositorioParque.existeId(parque.getId());
        if (existe) {
            throw new ExcepcionDuplicidad(EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
