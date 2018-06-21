package conmutadortrenes.filtros;


import conmutadortrenes.grafos.Arista;
import conmutadortrenes.grafos.Vertice;
import conmutadortrenes.grafos.dirigido.AristaDirigida;
import conmutadortrenes.grafos.dirigido.CaminoDirigido;
public class FiltroContieneCamino<V extends Vertice, A extends Arista & AristaDirigida> implements FiltroCamino<V,A> {
    private final CaminoDirigido<V,A> objectivePath;

    public FiltroContieneCamino(final CaminoDirigido<V, A> camino) {
        this.objectivePath = camino;
    }

    @Override
    public boolean passFilter(final CaminoDirigido<V,A> camino) {
        return objectivePath.comienzaCon(camino);
    }

}
