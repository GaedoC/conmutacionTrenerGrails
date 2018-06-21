package conmutadortrenes.app;

import java.io.File;
import java.util.List;

import conmutadortrenes.grafos.dirigido.GrafoDirigidoBuilder;
import conmutadortrenes.ingreso.Instruccion;
import conmutadortrenes.ingreso.InstruccionBuilder;
import conmutadortrenes.servicio.ConmutadorTrenes;
import conmutadortrenes.servicio.ConmutadorTrenesKiwiland;

public class Aplicacion {

    public static final String NOMBRE_ARCHIVO = "/datos.txt";

    public static void main(final String[] args) throws Exception {
        final ConmutadorTrenes conmutadorTrenes = new ConmutadorTrenesKiwiland(GrafoDirigidoBuilder.getEmptyGraph());
        File inputFile = new File(Aplicacion.class.getResource(NOMBRE_ARCHIVO).toURI());
        final List<Instruccion> instruccionesIngreso = new InstruccionBuilder(System.out).getInstruccionesDeArchivo(inputFile);
        for (final Instruccion instruccion : instruccionesIngreso) {
            instruccion.ejecutar(conmutadorTrenes);
        }
    }

}
