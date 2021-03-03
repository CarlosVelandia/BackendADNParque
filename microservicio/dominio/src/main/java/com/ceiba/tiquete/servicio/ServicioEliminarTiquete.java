package com.ceiba.tiquete.servicio;

import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;

public class ServicioEliminarTiquete {

    private final RepositorioTiquete repositorioTiquete;

    public ServicioEliminarTiquete(RepositorioTiquete repositorioTiquete) {
        this.repositorioTiquete = repositorioTiquete;
    }

    public void ejecutar(Long id) {
        this.repositorioTiquete.eliminar(id);
    }
}
