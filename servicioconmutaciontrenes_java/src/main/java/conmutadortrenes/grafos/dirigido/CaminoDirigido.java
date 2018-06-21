package conmutadortrenes.grafos.dirigido;

import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Camino;
import conmutadortrenes.grafos.Vertice;


public interface CaminoDirigido<V extends Vertice, A extends AristaDirigida & Arista> extends Camino<V,A> {
    int getCosteTotalCamino();
}
