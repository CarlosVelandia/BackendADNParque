package com.ceiba.tiquete.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.parque.puerto.dao.DaoParque;
import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.DayOfWeek;
import java.time.LocalDate;


public class ServicioCrearTiquete {

    private static final String EL_USUARIO_NO_EXISTE = "El suario no existe";
    private static final String EL_PARQUE_NO_EXISTE = "El parque no existe";


    private final RepositorioTiquete repositorioTiquete;
    private final RepositorioUsuario repositorioUsuario;
    private final RepositorioParque repositorioParque;
   // private final DaoParque daoParque;
    private final ValidadorTiquete validadorTiquete;

    public ServicioCrearTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioTiquete = repositorioTiquete;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
       // this.daoParque=daoParque;
        this.validadorTiquete=new ValidadorTiquete(this.repositorioTiquete,this.repositorioUsuario,this.repositorioParque);
    }

    public Long ejecutar(Tiquete tiquete) {
        validarExistenciaUsuario(tiquete);
        validarExistenciaParque(tiquete);
        validadorTiquete.validarDiaLunes(tiquete.getFechaCompra());
        validadorTiquete.maximoTiquetesPersona(tiquete);
        validadorTiquete.maximoTiquetesParque(tiquete);
        validadorTiquete.validarFinDeSemana(tiquete);
        return this.repositorioTiquete.crear(tiquete);
    }

    private void validarExistenciaUsuario(Tiquete tiquete) {
        boolean existe = this.repositorioUsuario.existeId(tiquete.getIdUsuario());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarExistenciaParque(Tiquete tiquete) {
        boolean existe = this.repositorioParque.existeId(tiquete.getIdParque());
        if (!existe) {
            throw new ExcepcionDuplicidad(EL_PARQUE_NO_EXISTE);
        }
    }
}
