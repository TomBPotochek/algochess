package fiuba.algo3.algochess;

public abstract class EstadoCasilla {

	protected Unidad unidad;
	
	public abstract EstadoCasillaOcupada colocarUnidad(Unidad unidad);
	
	public abstract EstadoCasillaLibre quitarUnidad();
	
	public Unidad obtenerUnidad() {
		return this.unidad;
	}
}
