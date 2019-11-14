package fiuba.algo3.algochess.tablero;

import fiuba.algo3.algochess.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.unidad.Unidad;

public abstract class EstadoCasilla {

	protected Unidad unidad;
	
	public abstract EstadoCasillaOcupada colocarUnidad(Unidad unidad) throws CasillaOcupadaException;
	
	public abstract EstadoCasillaLibre quitarUnidad() throws CasillaLibreException;
	
	public abstract Unidad obtenerUnidad();
}
