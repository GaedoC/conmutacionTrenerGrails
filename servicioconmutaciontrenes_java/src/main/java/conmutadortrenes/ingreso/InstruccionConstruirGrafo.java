package conmutadortrenes.ingreso;


import java.io.PrintStream;

import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.GrafoDirigido;
import conmutadortrenes.servicio.Ciudad;
import conmutadortrenes.servicio.ConmutadorTrenes;


class InstruccionConstruirGrafo extends AbstractInstruccion {

    public InstruccionConstruirGrafo(final String linea, PrintStream outputStream) {
        super(linea, outputStream);
    }

    @Override
    public void ejecutar(final ConmutadorTrenes conmutadorTrenes) {
        final String definicionGrafo = getLinea().substring(7);
        final String[] elementos = definicionGrafo.split(",");
        for (final String elemento : elementos) {
            agregarElemento(conmutadorTrenes.obtenerTodasLasRutas(), elemento);
        }

    }

    private void agregarElemento(final GrafoDirigido<Ciudad, DefaultAristaDirigida> grafo, final String elemento) {
        final String trimmedElement = elemento.trim();
        final Ciudad inicio = Ciudad.construir(String.valueOf(trimmedElement.charAt(0)));
        final Ciudad fin = Ciudad.construir(String.valueOf(trimmedElement.charAt(1)));
        final int ponderacion = Integer.valueOf(trimmedElement.substring(2));
        grafo.agregarVertice(inicio);
        grafo.agregarVertice(fin);
        grafo.agregarArista(inicio, fin, ponderacion);
    }

}
