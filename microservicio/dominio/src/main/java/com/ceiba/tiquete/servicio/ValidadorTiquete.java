package com.ceiba.tiquete.servicio;

import com.ceiba.parque.puerto.respositorio.RepositorioParque;
import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ValidadorTiquete {

    private static final String LUNES_NO_SE_VENDEN_TIQUETES = "Los Lunes no se pueden vender tiquetes por mantenimiento del parque";
    private static final String LIMITE_TIQUETES_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 tiquetes por persona";
    private static final String LIMITE_TIQUETES_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 tiquetes por dia";
    private static final int TIQUETES_POR_PERSONA = 5;
    private static final int TIQUETES_POR_PARQUE = 15;
    private static final double VALOR_TIQUETE_SEMANA = 15000;
    private static final double VALOR_TIQUETE_FIN_DE_SEMANA = 30000;



    private final RepositorioTiquete repositorioTiquete;
    private final RepositorioParque repositorioParque;
    private final RepositorioUsuario repositorioUsuario;

    public ValidadorTiquete(RepositorioTiquete repositorioTiquete, RepositorioUsuario repositorioUsuario, RepositorioParque repositorioParque) {
        this.repositorioTiquete = repositorioTiquete;
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioParque = repositorioParque;
    }

    public void validarDiaLunes(LocalDate fechaCompra) {

        if (fechaCompra.getDayOfWeek() == DayOfWeek.MONDAY) {
            throw new ExcepcionTiquete(LUNES_NO_SE_VENDEN_TIQUETES);
        }
    }
    public void validarFinDeSemana(Tiquete tiquete) {


        if (tiquete.getFechaCompra().getDayOfWeek() == DayOfWeek.FRIDAY) {
            System.out.println("es Viernes");
            tiquete.setValor(VALOR_TIQUETE_FIN_DE_SEMANA);
        }else {
            if (tiquete.getFechaCompra().getDayOfWeek()== DayOfWeek.SATURDAY) {
                System.out.println("es Sabado");
                tiquete.setValor(VALOR_TIQUETE_FIN_DE_SEMANA);
            }else {
                if (tiquete.getFechaCompra().getDayOfWeek()== DayOfWeek.SUNDAY) {
                    System.out.println("es Domingo");
                    tiquete.setValor(VALOR_TIQUETE_FIN_DE_SEMANA);
                }else{
                    tiquete.setValor(VALOR_TIQUETE_SEMANA);
                }
                //return repositorioTiquete.crear(tiquete);
            }
        }

    }

        public void maximoTiquetesParque(Tiquete tiquete){
        int tiquetesParque= this.repositorioTiquete.maximoTiquetesVendidos(tiquete.getFechaCompra(), tiquete.getIdParque());
        if (tiquetesParque >= TIQUETES_POR_PARQUE) {
            throw new ExcepcionTiquete(LIMITE_TIQUETES_POR_PARQUE_ALCANZADO);
        }
    }

    public void maximoTiquetesPersona(Tiquete tiquete) {
        int tiquetesPersona = this.repositorioTiquete.existeTiqueteFechaYCedula(tiquete.getFechaCompra(), tiquete.getIdUsuario());
        if (tiquetesPersona >= TIQUETES_POR_PERSONA) {
            throw new ExcepcionTiquete(LIMITE_TIQUETES_POR_PERSONA_ALCANZADO);
        }
    }
}

