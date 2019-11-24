package fiuba.algo3.algochess.model.tablero;

import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.unidad.Unidad;

public class EstadoCasillaOcupada extends EstadoCasilla {
	
	public EstadoCasillaOcupada(Unidad unaUnidad) {
		this.unidad = unaUnidad;
	}

	@Override
	public EstadoCasillaOcupada colocarUnidad(Unidad unidad) {
		throw new CasillaOcupadaException();
		
	}

	@Override
	public EstadoCasillaLibre quitarUnidad() {
		return new EstadoCasillaLibre();
		
	}
	
	@Override
	public Unidad obtenerUnidad() {
		return this.unidad;
	}	
}
