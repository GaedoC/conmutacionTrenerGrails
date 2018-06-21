package conmutadortrenes.grafos.dirigido;

import java.util.List;

import conmutadortrenes.filtros.FiltroCamino;
import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Grafo;
import conmutadortrenes.grafos.Vertice;


public interface GrafoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Grafo<V,A> {


    boolean agregarArista(final V inicio, final V fin, final int ponderacion);
    List<CaminoDirigido<V,A>> getCaminosFiltrados(V inicio, V fin, FiltroCamino<V,A> criterioFiltro);



}
