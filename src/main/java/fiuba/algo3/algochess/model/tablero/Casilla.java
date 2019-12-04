package fiuba.algo3.algochess.model.tablero;

import fiuba.algo3.algochess.model.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.juego.Observable;
import fiuba.algo3.algochess.model.unidad.Unidad;

public class Casilla extends Observable {
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
    	
    	this.notifyObservers();
    }
    
    public Unidad quitar() throws CasillaLibreException {
    	Unidad unidad = this.estado.obtenerUnidad();
    	this.estado = this.estado.quitarUnidad();
    	
    	this.notifyObservers();

    	return unidad;
    	
    }

    public EstadoCasilla getEstado(){
    	return this.estado;
	}

	public Unidad getUnidad() {
		
		return this.estado.obtenerUnidad();
	}
	
	public void atacar(float danio) {
		Unidad unidad = this.estado.obtenerUnidad();
		if (unidad.esAliada(this.equipo))
			unidad.recibirDanio(danio);
		else
			unidad.recibirDanio((float) (danio*1.05)); //extra 5% de danio
	}
    
    public boolean esAliada(Equipo otroEquipo) {
    	return (this.equipo == otroEquipo);
	}

}
