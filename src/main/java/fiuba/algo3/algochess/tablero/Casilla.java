package fiuba.algo3.algochess.tablero;

import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.unidad.Unidad;

public class Casilla {
	private EstadoCasilla estado;
	private Equipo equipo;
    
    public Casilla(Equipo equipo) {
    	this.estado = new EstadoCasillaLibre();
    	this.equipo = equipo;
    }
    
    public void mover(Unidad unidad) throws CasillaOcupadaException {
    	this.estado = this.estado.colocarUnidad(unidad);
    }
    
    public void colocar(Unidad unidad) throws CasillaOcupadaException, CasillaEnemigaException {
    	if (unidad.esAliada(this.equipo))
    		this.estado = this.estado.colocarUnidad(unidad);
    	else 
    		throw new CasillaEnemigaException();
    }
    
    public Unidad quitar() throws CasillaLibreException {
    	Unidad unidad = this.estado.obtenerUnidad();
    	this.estado = this.estado.quitarUnidad();
    	return unidad;
    	
    }

    public EstadoCasilla getEstado(){
    	return this.estado;
	}

	public Unidad getUnidad() {
		
		return this.estado.obtenerUnidad();
	}
    
}
