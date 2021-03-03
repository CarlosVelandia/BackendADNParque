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

    private static final String EL_USUARIO_YA_EXISTE = "El usuario ya existe en el sistema";

    @Mock
    private RepositorioUsuario repositorioUsuario;

    @InjectMocks
    private ServicioActualizarUsuario servicioActualizarUsuario;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(), Mockito.anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class, EL_USUARIO_YA_EXISTE);
    }

    @Test
    public void validarActualizarUsuarioTest() {
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioUsuario.existeId(usuario.getId())).thenReturn(true);
        //act
        servicioActualizarUsuario.ejecutar(usuario);
        //-assert
        Mockito.verify(repositorioUsuario).actualizar(usuario);
    }
/*
    @Test
    public void validarActualizarUsuarioTest(){
        //arrange
        Usuario usuario = new UsuarioTestDataBuilder().conId(1l).build();
        Mockito.when(repositorioUsuario.existeId(anyLong())).thenReturn(true);
    }

 */

/*
    @Test
    public void validarActualizarUsuarioTest() {
        // arrange
        Usuario usuario = new UsuarioTestDataBuilder().build();
        RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
        Mockito.when(repositorioUsuario.existeId(anyLong())).thenReturn(true);
        Mockito.when(repositorioUsuario.existeExcluyendoId(anyLong(), anyString())).thenReturn(true);
        ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);

        // act
        servicioActualizarUsuario.ejecutar(usuario);

        // assert
        Mockito.verify(repositorioUsuario, Mockito.times(1)).actualizar(usuario);
    }

 */
}
