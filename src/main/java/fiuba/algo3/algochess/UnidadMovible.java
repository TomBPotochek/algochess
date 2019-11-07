package fiuba.algo3.algochess;

public class UnidadMovible extends Unidad {

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
    
    public Posicion getPosicion() {
    	
    	return this.posicion;
    }
}
