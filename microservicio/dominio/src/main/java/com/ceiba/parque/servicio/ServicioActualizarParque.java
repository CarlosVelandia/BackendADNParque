package com.ceiba.parque.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.modelo.entidad.Parque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioActualizarParque {

    private static final String EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA = "El parque ya existe en el sistema";

    private final RepositorioParque repositorioParque;

    public ServicioActualizarParque(RepositorioParque repositorioParque){
        this.repositorioParque=repositorioParque;
    }

    public void ejecutar(Parque parque){
        validarExistenciaPrevia(parque);
        this.repositorioParque.actualizar(parque);
    }

    private void validarExistenciaPrevia(Parque parque){
        boolean existe =this.repositorioParque.existeExcluyendoId(parque.getId(), parque.getNombre());
        if(existe){
            throw new ExcepcionDuplicidad(EL_PARQUE_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
