package fiuba.algo3.algochess;

import fiuba.algo3.algochess.juego.Posicion;

public class Derecha implements Direccion {

    public Posicion calcularSiguientePosicion(Posicion posicion) {
        int posX = posicion.obtenerCoordenadaX() + 1;
        int posY = posicion.obtenerCoordenadaY();
        Posicion posicionSiguiente = new Posicion(posX, posY);
        return posicionSiguiente;
    }
}
