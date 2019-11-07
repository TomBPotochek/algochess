package fiuba.algo3.algochess;

public class Casilla {
	private EstadoCasilla estado;
	private String equipo;
    
    public Casilla(String equipo) {
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
    }
    
    public Unidad quitar() throws CasillaLibreException {
    	Unidad unidad = this.estado.obtenerUnidad();
    	this.estado = this.estado.quitarUnidad();
    	return unidad;
    	
    }
    
}
