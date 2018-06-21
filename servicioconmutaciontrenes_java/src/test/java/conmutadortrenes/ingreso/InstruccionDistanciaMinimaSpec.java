package conmutadortrenes.ingreso;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import conmutadortrenes.excepcion.CaminoNoEncontradoException;
import conmutadortrenes.ingreso.Instruccion;
import conmutadortrenes.ingreso.InstruccionCamino;
import conmutadortrenes.ingreso.InstruccionDistanciaMinima;
import conmutadortrenes.servicio.ConmutadorTrenes;

import java.io.PrintStream;

import static conmutadortrenes.grafos.Utils.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class InstruccionDistanciaMinimaSpec {
    @Mock
    private ConmutadorTrenes conmutador;
    @Mock
    private PrintStream salida;

    private Instruccion distanciaMinima;

    @Before
    public void inicializarInstruccion() {
        distanciaMinima = new InstruccionDistanciaMinima("The length of the shortest route (in terms of distance to travel) from A to C", salida);
    }

    @Test
    public void dadaUnaInstruccionDeDistanciaMinimaEntoncesDebeInvocarAInstruccionDistanciaMinima() {
        final int distance = 5;
        when(conmutador.distanciaMasCorta(construirUnaCiudad("A"), construirUnaCiudad("C"))).thenReturn(distance);
        distanciaMinima.ejecutar(conmutador);
        verify(salida).println(distance);
    }


    @Test
    public void cuandoDistanciaMinimaLanzaExcepcionDebeMostrarMensajeRutaNoEncontrada() {
        when(conmutador.distanciaMasCorta(construirUnaCiudad("A"), construirUnaCiudad("C"))).thenThrow(CaminoNoEncontradoException.class);
        distanciaMinima.ejecutar(conmutador);
        verify(salida).println(InstruccionCamino.MENSAJE_RUTA_NO_ENCONTRADA);
    }
}
