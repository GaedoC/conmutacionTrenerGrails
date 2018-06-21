package conmutadortrenes.ingreso;

import conmutadortrenes.servicio.ConmutadorTrenes;

public interface Instruccion {
    void ejecutar(ConmutadorTrenes conmutadorTrenes);
}
