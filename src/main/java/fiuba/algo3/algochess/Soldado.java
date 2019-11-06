package fiuba.algo3.algochess;

public class Soldado extends UnidadMovible {
	
	public Soldado(Posicion unaPosicion) {
		
		super(unaPosicion);
		
		this.vidaInicial = 100;
		this.vidaRestante = 100;
		this.costo = 1;
		this.danioAtaqueCuerpoACuerpo = 10;
		this.danioAtaqueADistancia = 0;

	}
	
    public void atacarCuerpoACuerpo(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueCuerpoACuerpo);
    }
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }
	

}
