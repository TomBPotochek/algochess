package fiuba.algo3.algochess;

import java.util.HashMap;

public class Tablero {
	
	private HashMap<Posicion, Casilla> tablero;
	
	//tamanio debe ser par para poder dividir el tablero en 2
	public Tablero(int tamanio) {
		for(int i = 1; i < tamanio +1; i++) {
			
			//esta separado en 2 for() porque despues deberian ser distintos las casillas de cada equipo
			for(int j = 1; j < tamanio/2 +1; j++) {
				Posicion pos = new Posicion(i, j);
				Casilla casilla = new Casilla(); //habria que agregar lo de aliado o enemigo
				this.tablero.put(pos, casilla);
			}
			
			for(int j = tamanio/2 +1; j < tamanio+1; j++) {
				Posicion pos = new Posicion(i, j);
				Casilla casilla = new Casilla(); //habria que agregar lo de aliado o enemigo
				this.tablero.put(pos, casilla);
			}
		}
	}


    public void moverUnidad(Posicion posicionOrigen, Posicion posicionDestino) {
    	Casilla casillaOrigen = this.tablero.get(posicionOrigen);
    	Casilla casillaDestino = this.tablero.get(posicionDestino);
    	
    	//no es responsabilidad de tablero saber si es movible o si el casillero es valido(?
    	Unidad unidad = casillaOrigen.quitar();
    	casillaDestino.colocar(unidad);
    	
    }
}
