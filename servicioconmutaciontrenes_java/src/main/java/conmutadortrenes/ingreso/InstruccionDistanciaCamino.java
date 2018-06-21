package conmutadortrenes.ingreso;



import java.io.PrintStream;
import java.util.List;

import conmutadortrenes.servicio.Ciudad;
import conmutadortrenes.servicio.ConmutadorTrenes;


class InstruccionDistanciaCamino extends InstruccionCamino {
    public InstruccionDistanciaCamino(final String linea, final PrintStream stream) {
        super(linea, stream);
    }

    @Override
    protected int ejecutarConmutador(ConmutadorTrenes conmutadorTrenes, Ciudad inicio, Ciudad fin, List<Ciudad> ciudadesIntermedias) {
        return conmutadorTrenes.distanciaRuta(inicio, fin, ciudadesIntermedias);
    }

}
