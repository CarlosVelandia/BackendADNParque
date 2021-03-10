package com.ceiba.tiquete.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.tiquete.modelo.entidad.Tiquete;
import com.ceiba.tiquete.puerto.repositorio.RepositorioTiquete;
import com.ceiba.tiquete.servicio.testdatabuilder.TiqueteTestDataBuilder;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.UsuarioTestDataBuilder;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class ServicioEliminarTiqueteTest {

    private static final String EL_TIQUETE_NO_EXISTE="El tiquete no existe en el sistema";

    @Mock
    private RepositorioTiquete repositorioTiquete;

    @InjectMocks
    private ServicioEliminarTiquete servicioEliminarTiquete;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void validarExistenciaPreviaTiqueteTest() {
        //arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(false);
        //act - assert
        BasePrueba.assertThrows(() -> servicioEliminarTiquete.ejecutar(tiquete.getId()), ExcepcionDuplicidad.class, EL_TIQUETE_NO_EXISTE);
    }

    @Test
    public void validarEliminarUsuarioTest() {
        // arrange
        Tiquete tiquete = new TiqueteTestDataBuilder().build();
        Mockito.when(repositorioTiquete.existeId(tiquete.getId())).thenReturn(true);
        // act - assert
        servicioEliminarTiquete.ejecutar(tiquete.getId());
        // assert
        Mockito.verify(repositorioTiquete).eliminar(tiquete.getId());
    }
}
