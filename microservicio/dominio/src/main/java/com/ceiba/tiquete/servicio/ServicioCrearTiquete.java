package com.ceiba.tiquete.servicio;

import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;

public class ServicioCrearTiquete {

    private final RepositorioTiquete repositorioTiquete;

    public ServicioCrearTiquete(RepositorioTiquete repositorioTiquete){
        this.repositorioTiquete=repositorioTiquete;
        }

    public Long ejecutar(Tiquete tiquete){
        return this.repositorioTiquete.crear(tiquete);
    }
}
