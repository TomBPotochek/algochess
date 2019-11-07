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

    public Distancia calcularDistancia(Posicion otraPosicion) {
        // hay que ver alguna forma mas elegante de convertir este entero a una Distancia
        int distancia = Math.abs(this.posX - otraPosicion.obtenerCoordenadaX()) +
                Math.abs(this.posY - otraPosicion.obtenerCoordenadaY());
        if(distancia < 3) return new DistanciaCorta();
        else if(distancia < 5) return new DistanciaMedia();
        else return new DistanciaLarga();
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
