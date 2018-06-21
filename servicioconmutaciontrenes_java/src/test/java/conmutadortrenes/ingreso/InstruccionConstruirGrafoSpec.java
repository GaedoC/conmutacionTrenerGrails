package conmutadortrenes.ingreso;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import conmutadortrenes.ingreso.Instruccion;
import conmutadortrenes.ingreso.InstruccionConstruirGrafo;
import conmutadortrenes.servicio.Ciudad;
import conmutadortrenes.servicio.ConmutadorTrenes;

import java.io.PrintStream;

import static conmutadortrenes.grafos.Utils.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class InstruccionConstruirGrafoSpec {
    @Mock
    private DefaultGrafoDirigido<Ciudad, DefaultAristaDirigida> grafo;
    @Mock
    private ConmutadorTrenes conmutadorTrenes;
    @Mock
    private PrintStream salida;

    Instruccion construccionGrafo;

    @Before
    public void inicializarInstruccion() {
        construccionGrafo= new InstruccionConstruirGrafo("Grafo: AB3, BA3", salida);
    }

    @Test
    public void dadaUnaInstruccionDeConstruirGrafoEntoncesDebeInvocarAInstruccionConstruirGrafo() {
        when(conmutadorTrenes.obtenerTodasLasRutas()).thenReturn(grafo);
        construccionGrafo.ejecutar(conmutadorTrenes);
        verify(conmutadorTrenes, atLeastOnce()).obtenerTodasLasRutas();
    }

    @Test
    public void cuandoSeConstruyeElGrafoEntoncesDebeConstruirSusAristasYVertices() {
        when(conmutadorTrenes.obtenerTodasLasRutas()).thenReturn(grafo);
        construccionGrafo.ejecutar(conmutadorTrenes);
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("A"));
        verify(grafo, times(2)).agregarVertice(construirUnaCiudad("B"));
        verify(grafo).agregarArista(construirUnaCiudad("A"), construirUnaCiudad("B"), 3);
        verify(grafo).agregarArista(construirUnaCiudad("B"), construirUnaCiudad("A"), 3);
    }
}
