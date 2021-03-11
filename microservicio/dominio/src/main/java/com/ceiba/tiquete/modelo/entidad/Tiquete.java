package com.ceiba.tiquete.modelo.entidad;

import lombok.Getter;
import lombok.Setter;

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

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.id = id;
        this.idUsuario = idUsuario;
        this.idParque = idParque;
        this.fechaCompra = LocalDate.parse(fechaCompra, formatter);
        this.valor = valor;
    }
}
