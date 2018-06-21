package conmutadortrenes.grafos.dirigido;

import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.DefaultArista;
import conmutadortrenes.grafos.Vertice;


public class DefaultAristaDirigida<V extends Vertice> extends DefaultArista<V> implements AristaDirigida<V> {

    private final int ponderacion;

    protected DefaultAristaDirigida(V verticeInicio, V verticeFin, int ponderacion) {
        super(verticeInicio, verticeFin);
        this.ponderacion = ponderacion;
    }

    public static <V extends Vertice, A extends AristaDirigida & Arista> A getNuevaAristaPonderada(final V verticeInicio, final V verticeFin, final int ponderacion) {
        return (A) new DefaultAristaDirigida<V>(verticeInicio, verticeFin, ponderacion);
    }

    @Override
    public int getPonderacion() {
        return ponderacion;
    }
}
