package com.ceiba.usuario.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioActualizarUsuarioTest {

    private static final String EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA = "El usuario no existe en el sistema";

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioActualizarUsuario servicioActualizarUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaUsuario() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        Mockito.when(repositorioUsuario.existeExcluyendoId(usuario.getId(), usuario.getCedula())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, EL_USUARIO_NO_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void validarActualizarUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioUsuario.existeExcluyendoId(usuario.getId(), usuario.getCedula())).thenReturn(true);
        // act - assert
        servicioActualizarUsuario.ejecutar(usuario);
        // assert
        Mockito.verify(repositorioUsuario).actualizar(usuario);
    }
}