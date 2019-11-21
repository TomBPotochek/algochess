package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.distancia.DistanciaCorta;
import fiuba.algo3.algochess.distancia.DistanciaLarga;
import fiuba.algo3.algochess.distancia.DistanciaMedia;
import fiuba.algo3.algochess.excepciones.PosicionInvalidaException;
import static fiuba.algo3.algochess.juego.ProveedorConstantes.TAMANIO_TABLERO;

//import java.util.ArrayList;
import java.util.Objects;

public class Posicion {
    private int posX;
    private int posY;

    public Posicion(int coordenadaX, int coordenadaY) {
    	if ((1 <= coordenadaX && coordenadaX <= TAMANIO_TABLERO) && (1 <= coordenadaY && coordenadaY <= TAMANIO_TABLERO)) {
    		posX = coordenadaX;
    		posY = coordenadaY;
    	}
    	else throw new PosicionInvalidaException("posicion fuera de rango");
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
     
        int ladoA =  Math.abs(this.posX - otraPosicion.obtenerCoordenadaX());
        int ladoB = Math.abs(this.posY - otraPosicion.obtenerCoordenadaY());
        int distancia = Math.max(ladoA, ladoB);
        if(distancia < 3) return new DistanciaCorta();
        else if(distancia < 6) return new DistanciaMedia();
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
