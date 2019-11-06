package fiuba.algo3.algochess;

import java.util.Objects;

public class Posicion {
    private int posX;
    private int posY;

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
        
    	return (Math.abs(this.posX - otraPosicion.obtenerCoordenadaX()) < 2 ) && 
    			(Math.abs(this.posY - otraPosicion.obtenerCoordenadaY()) < 2 );
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
