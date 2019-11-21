package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;
import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

import java.util.HashMap;

public class Tablero {
	
	private HashMap<Posicion, Casilla> tablero = new HashMap<Posicion, Casilla>();
	private int tamanio;
	
	//tamanio debe ser par para poder dividir el tablero en 2
	public Tablero(int tamanio, Equipo equipo1, Equipo equipo2) {
		this.tamanio = tamanio;
		for(int i = 1; i < tamanio +1; i++) {
			
			//esta separado en 2 for() porque despues deberian ser distintos las casillas de cada equipo
			for(int j = 1; j < tamanio/2 +1; j++) {
				Posicion pos = new Posicion(i, j);
				Casilla casilla = new Casilla(equipo1); //habria que agregar lo de aliado o enemigo
				this.tablero.put(pos, casilla);
			}
			
			for(int j = tamanio/2 +1; j < tamanio+1; j++) {
				Posicion pos = new Posicion(i, j);
				Casilla casilla = new Casilla(equipo2); //habria que agregar lo de aliado o enemigo
				this.tablero.put(pos, casilla);
			}
		}
	}


    public void moverUnidad(Posicion posicionOrigen, Posicion posicionDestino) { //hay que validar que una posicion sea valida? ej no sea 999, 999
    	
    	Casilla casillaOrigen = this.tablero.get(posicionOrigen);
    	Casilla casillaDestino = this.tablero.get(posicionDestino);
    	
    	//no es responsabilidad de tablero saber si es movible o si el casillero es valido(o si?
    	Unidad unidad = casillaOrigen.quitar();
    	
    	try {
    		casillaDestino.mover(unidad);    //Problema: si este tira excepcion, la unidad ya se quito de casillaOrigen
    	}
    	catch (CasillaOcupadaException ex) {
    		casillaOrigen.mover(unidad);
    		throw new CasillaOcupadaException();
    	}
    	
    }
    
    public void colocarUnidad(Unidad unidad, Posicion posicion) {
    	Casilla casilla = this.tablero.get(posicion);
    	casilla.colocar(unidad);
    }

    public void quitarUnidad(Unidad unaUnidad) {
		Casilla casilla = this.tablero.get(unaUnidad.obtenerPosicion());
		casilla.quitar();
	}

    //para testing
    public Casilla obtenerCasilla(Posicion posicion) {
    	return this.tablero.get(posicion);
    }


	public Unidad obtenerUnidad(Posicion posicion) {

		return this.obtenerCasilla(posicion).getUnidad();
	}

	public int getTamanio() {
		return this.tamanio;
	}
}
