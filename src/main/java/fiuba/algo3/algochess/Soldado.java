package fiuba.algo3.algochess;

public class Soldado extends UnidadMovible {
	
	public Soldado(Posicion unaPosicion) {
		this.vidaInicial = 100;
		this.vidaRestante = 100;
		this.costo = 1;
		this.danioAtaqueCuerpoACuerpo = 10;
		this.danioAtaqueADistancia = 0;
		this.posicion = unaPosicion;
	}
	
    public void atacarCuerpoACuerpo(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueCuerpoACuerpo);
    }
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }
	

}
