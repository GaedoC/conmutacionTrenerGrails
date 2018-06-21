package conmutadortrenes.filtros;


import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Vertice;
import conmutadortrenes.grafos.dirigido.AristaDirigida;
import conmutadortrenes.grafos.dirigido.CaminoDirigido;


public class FiltroCaminoConAristasRepetidas<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> camino) {
        return !camino.tieneAristasRepetidas();
    }

}
