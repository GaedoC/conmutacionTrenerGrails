package conmutadortrenes.filtros;


import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Vertice;
import conmutadortrenes.grafos.dirigido.AristaDirigida;
import conmutadortrenes.grafos.dirigido.CaminoDirigido;


public class FiltroMaximoParadas<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maximoParadas;

    public FiltroMaximoParadas(final int maximoParadas) {
        this.maximoParadas = maximoParadas;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> path) {
        return path.getNumeroSaltos() <= maximoParadas;
    }

}
