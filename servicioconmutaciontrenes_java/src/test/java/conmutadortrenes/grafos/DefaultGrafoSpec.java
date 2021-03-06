package conmutadortrenes.grafos;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.GrafoDirigido;
import conmutadortrenes.servicio.Ciudad;

import static org.junit.Assert.*;
import static conmutadortrenes.grafos.Utils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;


public class DefaultGrafoSpec {
    private GrafoDirigido<Ciudad, DefaultAristaDirigida> grafo;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void inicializarGrafo(){
        grafo= Utils.construirGrafoPrueba();
    }

    @Test
    public void cuandoSeAgregaUnVerticeNuloALGrafoEntoncesSeEsperaExcepcion(){
        expected.expect(IllegalArgumentException.class);
        grafo.agregarVertice(null);
        fail("Debio lanzar una excepcion");
    }

    @Test
    public void cuandoSeAgregaUnVerticeNoNuloYQueNoExistaEntoncesRetornaTrue(){
        assertTrue(grafo.agregarVertice(construirUnaCiudadX()));
    }

    @Test
    public void cuandoSeAgregaUnVerticeNoNuloYQueYaExisteEntoncesRetornaFalse(){
        grafo.agregarVertice(construirUnaCiudadX());
        assertFalse(grafo.agregarVertice(construirUnaCiudadX()));
    }

    @Test
    public void cuandoSeQuiereAgregarUnaAristaEntoncesSeDebeEspecificarSusVertices(){
        assertTrue(grafo.agregarArista(construirUnaCiudad("C"), construirUnaCiudad("B")));
    }

    @Test
    public void cuandoSeQuiereAgregarUnaAristaExistenteEntoncesEstaNuevaReemplazaALaAnterior(){
        grafo.agregarArista(construirUnaCiudad("D"),construirUnaCiudad("E"));
        grafo.agregarArista(construirUnaCiudad("D"), construirUnaCiudad("E"));
    }


    @Test
    public void cuandoSePideUnaAristaQueSiExisteEntoncesLaRetorna(){
       assertNotNull(grafo.getArista(construirUnaCiudad("A"), construirUnaCiudad("B")));
    }
    @Test
    public void cuandoSePideUnaAristaQueNoExisteEntoncesRetornaNull(){
        assertNull(grafo.getArista(construirUnaCiudad("D"), construirUnaCiudad("A")));
    }

    @Test
    public void cuandoSePideUnaAristaCuyoVerticeNoExisteEntoncesRetornaExcepcion(){
        expected.expect(IllegalArgumentException.class);
        grafo.getArista(construirUnaCiudad("G"), construirUnaCiudad("H"));
    }

    @Test
    public void cuandoSePideTodosLosVerticesEntoncesRetornaUnSetConVertices(){
        assertThat(grafo.getTodosVertices(),containsInAnyOrder(getVerticesGrafoPrueba()));

    }





}

