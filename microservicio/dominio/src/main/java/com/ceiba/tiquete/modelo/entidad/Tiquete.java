package com.ceiba.tiquete.modelo.entidad;


import com.ceiba.tiquete.excepcion.ExcepcionTiquete;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.validarNumerico;
import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;


@Getter
@Setter
public class Tiquete {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA = "Se debe ingresar la fecha de la compra";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE = "Se debe ingresar el id del parque";
    private static final String EL_ID_USUARIO_DEBE_SER_NUMERICO = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";
    private static final String EL_ID_PARQUE_DEBE_SER_NUMERICO = "La Cedula debe ser numerica, no debe contener simbolos, ni espacios";

    private static final String LUNES_NO_SE_VENDEN_TIQUETES = "Los Lunes no se pueden vender tiquetes por mantenimiento del parque";
    private static final String LIMITE_TIQUETES_POR_PERSONA_ALCANZADO = "Solo se permite un maximo de 5 tiquetes por persona";
    private static final String LIMITE_TIQUETES_POR_PARQUE_ALCANZADO = "Solo se dispone de un maximo de 50 tiquetes por dia";
    private static final int MAXIMO_TIQUETES_POR_PERSONA = 5;
    private static final int MAXIMO_TIQUETES_POR_PARQUE = 15;
    private static final double VALOR_TIQUETE_SEMANA = 15000;
    private static final double VALOR_TIQUETE_FIN_DE_SEMANA = 30000;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private LocalDate fechaCompra;
    private double valor;

    public Tiquete(Long id, Long idUsuario, Long idParque, String fechaCompra, Double valor) {

        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarObligatorio(idParque, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA);
        validarNumerico(Long.toString(idUsuario), EL_ID_USUARIO_DEBE_SER_NUMERICO);
        validarNumerico(Long.toString(idParque), EL_ID_PARQUE_DEBE_SER_NUMERICO);
        this.fechaCompra = LocalDate.parse(fechaCompra, formatter);
        validarFinDeSemana(this.fechaCompra);
        validarDiaLunes(this.fechaCompra);

        this.id = id;
        this.idUsuario = idUsuario;
        this.idParque = idParque;

       // this.valor = valor;

    }

    public void validarDiaLunes(LocalDate fechaCompra) {
        if (fechaCompra.getDayOfWeek() == DayOfWeek.MONDAY) {
            throw new ExcepcionTiquete(LUNES_NO_SE_VENDEN_TIQUETES);
        }
    }

    public void validarFinDeSemana(LocalDate fechaCompra) {
        if (fechaCompra.getDayOfWeek() == DayOfWeek.FRIDAY
                || fechaCompra.getDayOfWeek() == DayOfWeek.SATURDAY
                || fechaCompra.getDayOfWeek() == DayOfWeek.SUNDAY) {
            setValor(VALOR_TIQUETE_FIN_DE_SEMANA);
        } else {
            setValor(VALOR_TIQUETE_SEMANA);
        }
    }
}
