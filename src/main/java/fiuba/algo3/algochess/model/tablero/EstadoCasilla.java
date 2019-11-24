package fiuba.algo3.algochess.model.tablero;

import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.unidad.Unidad;

public abstract class EstadoCasilla {

	protected Unidad unidad;
	
	public abstract EstadoCasillaOcupada colocarUnidad(Unidad unidad) throws CasillaOcupadaException;
	
	public abstract EstadoCasillaLibre quitarUnidad() throws CasillaLibreException;
	
	public abstract Unidad obtenerUnidad();
}
