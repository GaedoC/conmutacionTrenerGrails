package conmutadortrenes.ingreso;



import java.io.PrintStream;

import conmutadortrenes.excepcion.CaminoNoEncontradoException;
import conmutadortrenes.servicio.Ciudad;
import conmutadortrenes.servicio.ConmutadorTrenes;


class InstruccionDistanciaMinima extends AbstractInstruccion {


    public InstruccionDistanciaMinima(final String linea, final PrintStream stream) {
        super(linea, stream);

    }

    @Override
    public void ejecutar(final ConmutadorTrenes conmutadorTrenes) {
        final Ciudad inicio = Ciudad.construir(String.valueOf(getLinea().charAt(71)));
        final Ciudad fin = Ciudad.construir(String.valueOf(getLinea().charAt(76)));
        try {
            outputStream.println(conmutadorTrenes.distanciaMasCorta(inicio, fin));
        } catch (final CaminoNoEncontradoException e) {
            outputStream.println(InstruccionCamino.MENSAJE_RUTA_NO_ENCONTRADA);
        }
    }
}
