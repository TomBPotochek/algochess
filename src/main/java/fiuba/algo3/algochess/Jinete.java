package fiuba.algo3.algochess;

public class Jinete extends UnidadMovible {
    public Jinete(Posicion unaPosicion) {
    	
    	super(unaPosicion);
    	
		this.vidaInicial = 100;
		this.vidaRestante = vidaInicial;
		this.costo = 5;
	    this.danioAtaqueCuerpoACuerpo = 5;
	    this.danioAtaqueADistancia = 15;
    }
    
    public void atacarCuerpoACuerpo(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueCuerpoACuerpo);
    }
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }
}
