package com.ceiba.tiquete.modelo.entidad;

import lombok.Getter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Tiquete {

    private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA = "Se debe ingresar la fecha de la compra";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO = "Se debe ingresar el id del usuario";
    private static final String SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE = "Se debe ingresar el id del parque";

    public static final double VALOR_TIQUETE = 15000;

    private Long id;
    private Long idUsuario;
    private Long idParque;
    private LocalDate fechaCompra;
    private double valor;

    public Tiquete(Long id, Long idUsuario, Long idParque, String fechaCompra, Double valor) {
        validarObligatorio(idUsuario, SE_DEBE_INGRESAR_EL_ID_DEL_USUARIO);
        validarObligatorio(idParque, SE_DEBE_INGRESAR_EL_ID_DEL_PARQUE);
        validarObligatorio(fechaCompra, SE_DEBE_INGRESAR_LA_FECHA_DE_COMPRA);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        this.id = id;
        this.idUsuario = idUsuario;
        this.idParque = idParque;
        this.fechaCompra = LocalDate.parse(fechaCompra, formatter);
        this.valor = VALOR_TIQUETE;
    }
}
