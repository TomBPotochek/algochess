package fiuba.algo3.algochess;

public class Derecha implements Direccion {

    public Posicion calcularSiguientePosicion(Posicion posicion) {
        int posX = posicion.obtenerCoordenadaX() + 1;
        int posY = posicion.obtenerCoordenadaY();
        Posicion posicionSiguiente = new Posicion(posX, posY);
        return posicionSiguiente;
    }
}
