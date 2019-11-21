package fiuba.algo3.algochess.tablero;

import fiuba.algo3.algochess.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.unidad.Unidad;

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
