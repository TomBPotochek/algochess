package fiuba.algo3.algochess;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algochess.*; //mas facil que poner cada una

public class UnidadMovibleTest {
    @Test
    public void test01UnidadMoviblePuedeMoverseEnTodasLasDirecciones() {
        Tablero tablero = new Tablero();
        Posicion posicionInicial = new Posicion(2,3);
        Curandero unidad = new Curandero();
        unidad.setPosicion(posicionInicial);
        Derecha direccion = new Derecha();
        unidad.mover(direccion, tablero);
        Assert.assertTrue(posicionInicial.esAdyacente(unidad.obtenerPosicion()));
    }
}