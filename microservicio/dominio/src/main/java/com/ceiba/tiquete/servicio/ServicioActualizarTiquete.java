package com.ceiba.tiquete.servicio;

import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;

public class ServicioActualizarTiquete {

    private final RepositorioTiquete repositorioTiquete;

    public ServicioActualizarTiquete(RepositorioTiquete repositorioTiquete){
        this.repositorioTiquete=repositorioTiquete;
    }

    public void ejecutar(Tiquete tiquete){
        this.repositorioTiquete.actualizar(tiquete);
    }
}
