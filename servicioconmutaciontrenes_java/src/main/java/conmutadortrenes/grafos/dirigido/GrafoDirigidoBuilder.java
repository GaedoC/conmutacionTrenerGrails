package conmutadortrenes.grafos.dirigido;

import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.DefaultGrafoDirigido;
import conmutadortrenes.grafos.dirigido.GrafoDirigido;
import conmutadortrenes.servicio.Ciudad;

public class GrafoDirigidoBuilder {

    public static GrafoDirigido<Ciudad, DefaultAristaDirigida> getEmptyGraph() {
        return new DefaultGrafoDirigido<Ciudad,DefaultAristaDirigida>();
    }


}
