package fiuba.algo3.algochess;

public class Casilla {
	private EstadoCasilla estado;
    
    public Casilla() {
    	this.estado = new EstadoCasillaLibre();
    }
    
    public void colocar(Unidad unidad) {
    	this.estado = new EstadoCasillaOcupada(unidad);
    }
    
    public Unidad quitar() {
    	Unidad unidad = this.estado.obtenerUnidad();
    	this.estado = estado.quitarUnidad();
    	return unidad;
    	
    }
}
