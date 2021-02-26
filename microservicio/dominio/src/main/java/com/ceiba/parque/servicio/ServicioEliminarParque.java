package com.ceiba.parque.servicio;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;

public class ServicioEliminarParque {

    private final RepositorioParque repositorioParque;

    public ServicioEliminarParque(RepositorioParque repositorioParque){
        this.repositorioParque= repositorioParque;
    }

    public void ejecutar(Long id) {
        this.repositorioParque.eliminar(id);
    }
}
