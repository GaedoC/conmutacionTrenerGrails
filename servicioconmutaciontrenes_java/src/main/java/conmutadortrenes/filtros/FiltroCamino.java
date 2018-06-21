package conmutadortrenes.filtros;


import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Vertice;
import conmutadortrenes.grafos.dirigido.AristaDirigida;
import conmutadortrenes.grafos.dirigido.CaminoDirigido;


public interface FiltroCamino<V extends Vertice, A extends Arista & AristaDirigida> {
    boolean passFilter(final CaminoDirigido<V,A> camino);
}
