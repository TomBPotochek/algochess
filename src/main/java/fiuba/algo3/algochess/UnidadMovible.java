package fiuba.algo3.algochess;

public abstract class UnidadMovible extends Unidad {

	UnidadMovible(Posicion posicionInicial, String equipo) {
		
		super(posicionInicial, equipo);
	}
	
	public void mover(Posicion nuevaPosicion, Tablero tablero) throws MovimientoInvalidoException, CasillaOcupadaException {
 
    	if (!this.posicion.esAdyacente(nuevaPosicion))
    		throw new MovimientoInvalidoException("Las unidades se mueven de a un casillero");
    	
    	tablero.moverUnidad(this.posicion, nuevaPosicion);
    	
    	this.setPosicion(nuevaPosicion);
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
