package conmutadortrenes.grafos;


import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import conmutadortrenes.grafos.dirigido.CaminoDirigido;
import conmutadortrenes.grafos.dirigido.DefaultAristaDirigida;
import conmutadortrenes.grafos.dirigido.DefaultCaminoDirigido;
import conmutadortrenes.grafos.dirigido.GrafoDirigido;
import conmutadortrenes.servicio.Ciudad;

import static org.junit.Assert.*;
import static conmutadortrenes.grafos.Utils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class DefaultCaminoSpec {

    private CaminoDirigido<Ciudad,DefaultAristaDirigida> camino;
    private final DefaultAristaDirigida abArista = DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("A"), construirUnaCiudad("B"), 5);
    private final DefaultAristaDirigida bcArista = DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("B"), construirUnaCiudad("C"), 15);
    private final DefaultAristaDirigida cdArista = DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("C"), construirUnaCiudad("D"), 5);
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Before
    public void initPath() {
        camino = DefaultCaminoDirigido.getCaminoVacio();
        camino.agregarArista(abArista);
        camino.agregarArista(bcArista);
        camino.agregarArista(cdArista);
    }

    @Test
    public void dadoUnaAristaNoConsecutivaEntoncesOcurreExcepcion() {
        DefaultAristaDirigida aristaNoConsecutiva = DefaultAristaDirigida.getNuevaAristaPonderada(construirUnaCiudad("A"), construirUnaCiudad("C"), 5);
        expected.expect(IllegalArgumentException.class);
        camino.agregarArista(aristaNoConsecutiva);
    }

    @Test
    public void cuandoSePideElCostoTotalEntoncesEsIgualALaSumaDePonderacionesDeCadaArista() {
        assertThat(camino.getCosteTotalCamino(), equalTo(25));
    }

    @Test
    public void cuandoSePideElNumeroDeSaltosEntoncesElIgualAlNumeroDeAriastas() {
        assertThat(camino.getNumeroSaltos(), equalTo(3));
    }







}
