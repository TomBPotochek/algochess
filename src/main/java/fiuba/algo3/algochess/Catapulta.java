package fiuba.algo3.algochess;

public class Catapulta extends Unidad implements Atacante {
    public Catapulta(Posicion unaPosicion, String equipo) {

    	super(unaPosicion, equipo);
  
    	this.vidaInicial = 50;
        this.vidaRestante = vidaInicial;
        this.costo = 5;
		this.posicion = unaPosicion;
		this.danioAtaqueADistancia = 20;
		this.danioAtaqueCuerpoACuerpo = 0;
   }
    
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }


	@Override
	public void atacar(Unidad unaUnidad, Tablero tablero) {
		// este metodo podria ir en otro lado porque es igual para todos los atacantes
		Distancia distancia = this.obtenerPosicion().calcularDistancia(unaUnidad.obtenerPosicion());
		distancia.atacar(this, unaUnidad);
	}

	@Override
	public void atacarADistanciaCorta(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaMedia(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
    	// hay atacar recursivamente a las unidades contiguas
		unaUnidad.recibirDanio(danioAtaqueADistancia);
	}
}