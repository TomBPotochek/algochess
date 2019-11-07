package fiuba.algo3.algochess;

public class Soldado extends UnidadMovible implements Atacante{

	public Soldado(Posicion unaPosicion, String equipo) {
		
		super(unaPosicion, equipo);
		
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
		// tirar excepcion
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
		// tirar excepcion
	}



}
