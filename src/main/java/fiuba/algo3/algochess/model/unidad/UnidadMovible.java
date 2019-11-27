package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.excepciones.PosicionInvalidaException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public abstract class UnidadMovible extends Unidad {

	UnidadMovible(Posicion posicionInicial, Equipo equipo) {
		
		super(posicionInicial, equipo);
	}
	
	public void mover(Direccion direccion, Tablero tablero) throws MovimientoInvalidoException {
 
		try {
			Posicion nuevaPosicion = direccion.calcularPosicionSiguiente(this.posicion);
    	
			tablero.moverUnidad(this.posicion, nuevaPosicion);
    	
			this.setPosicion(nuevaPosicion);
		} catch (PosicionInvalidaException | CasillaOcupadaException ex) {
			throw new MovimientoInvalidoException(ex.getMessage());
		}
    }
		

    private void setPosicion(Posicion nuevaPosicion) {
    	
    	this.posicion = nuevaPosicion;
    }

    //catapulta no puede recibir vida. solo las unidades movibles
	public void recibirVida(int vida) {
		
		if (this.vidaRestante + vida < this.vidaInicial)
			this.vidaRestante += vida;
		
		else
			this.vidaRestante = this.vidaInicial;
	}
}
