package fiuba.algo3.algochess;

public class EstadoCasillaLibre extends EstadoCasilla {

	@Override
	public EstadoCasillaOcupada colocarUnidad(Unidad unaUnidad) {
		return new EstadoCasillaOcupada(unidad);
		
	}

	@Override
	public EstadoCasillaLibre quitarUnidad() {
		throw new CasillaLibreException;
		
	}

}
