package main.java.fiuba.algo3.algochess;

public class Posicion {
    private int posX;
    private int posY;
    private Boolean sectorAliado;

    public Posicion(int coordenadaX, int coordenadaY) {
        posX = coordenadaX;
        posY = coordenadaY;
    }
    public int obtenerCoordenadaX() {
        return posX;
    }
    public int obtenerCoordenadaY() {
        return posY;
    }

    public boolean esAdyacente(Posicion otraPosicion) {
        return true;
    }
}
