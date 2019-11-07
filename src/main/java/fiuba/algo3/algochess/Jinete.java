package fiuba.algo3.algochess;

public class Jinete extends UnidadMovible implements Atacante {
    public Jinete(Posicion unaPosicion) {
    	
    	super(unaPosicion);
    	
		this.vidaInicial = 100;
		this.vidaRestante = vidaInicial;
		this.costo = 3;
	    this.danioAtaqueCuerpoACuerpo = 5;
	    this.danioAtaqueADistancia = 15;
    }
    
    public void atacarCuerpoACuerpo(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueCuerpoACuerpo);
    }
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }

	@Override
	public void atacar(Unidad unaUnidad, Tablero tablero) {
		
		unaUnidad.recibirDanio(danioAtaqueCuerpoACuerpo);
	}
}
