package fiuba.algo3.algochess;

public class Jinete extends UnidadMovible implements Atacante {
    public Jinete(Posicion unaPosicion, String equipo) {
    	
    	super(unaPosicion, equipo);
    	
		this.vidaInicial = 100;
		this.vidaRestante = vidaInicial;
		this.costo = 3;
	    this.danioAtaqueCuerpoACuerpo = 5;
	    this.danioAtaqueADistancia = 15;
    }
    
//    public void atacarCuerpoACuerpo(Unidad otraUnidad) {
//    	otraUnidad.recibirDanio(this.danioAtaqueCuerpoACuerpo);
//    }
//
//    public void atacarADistancia(Unidad otraUnidad) {
//    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
//    }

	@Override
	public void atacar(Unidad unaUnidad, Tablero tablero) {
		// este metodo podria ir en otro lado porque es igual para todos los atacantes
    	Distancia distancia = this.obtenerPosicion().calcularDistancia(unaUnidad.obtenerPosicion());
		distancia.atacar(this, unaUnidad);
	}

	@Override
	public void atacarADistanciaCorta(Unidad unaUnidad) {
    	// chequear condiciones
		unaUnidad.recibirDanio(danioAtaqueCuerpoACuerpo);
	}
	@Override
	public void atacarADistanciaMedia(Unidad unaUnidad) {
    	// chequear condiciones
		unaUnidad.recibirDanio(danioAtaqueADistancia);
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
}
