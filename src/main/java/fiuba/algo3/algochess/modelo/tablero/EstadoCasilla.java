package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

public abstract class EstadoCasilla {

	protected Unidad unidad;
	
	public abstract EstadoCasillaOcupada colocarUnidad(Unidad unidad) throws CasillaOcupadaException;
	
	public abstract EstadoCasillaLibre quitarUnidad() throws CasillaLibreException;
	
	public abstract Unidad obtenerUnidad();
}
