package fiuba.algo3.algochess;

import java.util.Objects;

public class Posicion {
    private int posX;
    private int posY;
//    private Boolean sectorAliado;

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
    
    @Override
    public boolean equals(Object objeto) {
    	if (this == objeto)
    		return true;
    	if (objeto == null || (this.getClass() != objeto.getClass()))
    		return false;
    	Posicion pos = (Posicion) objeto;
    	return (this.posX == pos.posX) && (this.posY == pos.posY);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(this.posX, this.posY);
    }
}
