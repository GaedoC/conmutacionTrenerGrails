package conmutadortrenes.filtros;


import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Vertice;
import conmutadortrenes.grafos.dirigido.AristaDirigida;
import conmutadortrenes.grafos.dirigido.CaminoDirigido;

public class FiltroCaminoDistancia<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final int maximaDistancia;

    public FiltroCaminoDistancia(final int maximaDistancia) {
        this.maximaDistancia = maximaDistancia;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> camino) {
        return ((CaminoDirigido)camino).getCosteTotalCamino() < maximaDistancia;
    }

}
