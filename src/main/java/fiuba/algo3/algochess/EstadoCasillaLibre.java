package fiuba.algo3.algochess;

public class EstadoCasillaLibre extends EstadoCasilla {

	@Override
	public EstadoCasillaOcupada colocarUnidad(Unidad unaUnidad) {
		return new EstadoCasillaOcupada(unaUnidad);
		
	}

	@Override
	public EstadoCasillaLibre quitarUnidad() {
		throw new CasillaLibreException();
	}
	
	@Override
	public Unidad obtenerUnidad() {
		throw new CasillaLibreException();
	}

}
