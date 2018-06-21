package conmutadortrenes.grafos.dirigido;


import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import conmutadortrenes.grafos.dirigido.CaminoDirigido;
import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.DefaultCaminoDirigido;
import conmutadortrenes.servicio.Ciudad;

import static conmutadortrenes.grafos.Utils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

public class DefaultCaminoDirigidoSpec {
    private CaminoDirigido<Ciudad,DefaultAristaDirigida> camino;
    @Before
    public void inicializarCamino(){
    camino = construirCaminoPrueba();
    }

    @Test
    public void laDistanciaTotalDelCaminoDebeSerlaSumaDeLasDistanciasDeLasAristas(){
        assertEquals(3+4+5, camino.getCosteTotalCamino());
    }

    @Test
    public void dadoUnGrafoConTresAristasElNumeroDeSaltosDebeSerIgualAlNumeroDeAristas(){
        assertEquals(3, camino.getNumeroSaltos());
    }

    @Test
    public void cuandoElCaminoNoTieneAristasRepetidasDebeRetornarQueNoTieneAristasRepetidas(){
        assertFalse(camino.tieneAristasRepetidas());
    }

    @Test
    public void cuandoElCaminoTieneAristasRepetidasDebeRetornarQueTieneAristasRepetidas(){
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("Z"),construirUnaCiudad("X"),6));
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("X"),construirUnaCiudad("Y"),7));
        assertTrue(camino.tieneAristasRepetidas());
    }
    public void cuandoUnCaminoEsParteDeOtroSeDiceQueElSegundoComienzaConElPrimero(){
        CaminoDirigido<Ciudad,DefaultAristaDirigida> subCamino= DefaultCaminoDirigido.copiarCamino(camino);
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("Z"),construirUnaCiudad("X"),6));
        camino.agregarArista(DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("X"),construirUnaCiudad("Y"),7));
        assertTrue(camino.comienzaCon(subCamino));
    }







}
