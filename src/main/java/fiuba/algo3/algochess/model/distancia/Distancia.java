package fiuba.algo3.algochess.model.distancia;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

import java.util.ArrayList;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.unidad.Arma;



public abstract class Distancia {
	protected int de;
	protected int hasta;
	
	public Distancia(int de, int hasta) {
		this.de = de;
		this.hasta = hasta;
	}
	
    public abstract float atacar(Arma arma);
    
    public ArrayList<Posicion> obtenerPosicionesCercanas(Posicion unaPosicion) {
    	ArrayList<Posicion> posiciones = new ArrayList<Posicion>();
    	for (int i = 1; i <= TAMANIO_TABLERO; i++) {
    		for (int j = 1; j <= TAMANIO_TABLERO; j++) {
    			Posicion posicion = new Posicion(i,j);
    			if (posicion.calcularDistancia(unaPosicion).equals(this)) 
    				posiciones.add(posicion);
    		}
    	}
    	return posiciones;
    }
    
}
