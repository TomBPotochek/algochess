package fiuba.algo3.algochess;

public abstract class EstadoCasilla {

	protected Unidad unidad;
	
	public abstract EstadoCasillaOcupada colocarUnidad(Unidad unidad) throws CasillaOcupadaException;
	
	public abstract EstadoCasillaLibre quitarUnidad() throws CasillaLibreException;
	
	public abstract Unidad obtenerUnidad();
}
