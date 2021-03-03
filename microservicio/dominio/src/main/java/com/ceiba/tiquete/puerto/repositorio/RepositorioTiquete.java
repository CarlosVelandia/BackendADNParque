package com.ceiba.tiquete.puerto.repositorio;

import com.ceiba.tiquete.modelo.entidad.Tiquete;

public interface RepositorioTiquete {
    /**
     * Permite crear un tiquete
     *
     * @param tiquete
     * @return el id generado
     */
    Long crear(Tiquete tiquete);

    /**
     * Permite actualizar un tiquete
     *
     * @param tiquete
     */
    void actualizar(Tiquete tiquete);

    /**
     * Permite eliminar un tiquete
     *
     * @param id
     */
    void eliminar(Long id);

}
