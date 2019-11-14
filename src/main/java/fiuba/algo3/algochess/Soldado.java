package fiuba.algo3.algochess;

import static fiuba.algo3.algochess.ProveedorConstantes.*;

public class Soldado extends UnidadMovible implements Atacante{

	public Soldado(Posicion unaPosicion, Equipo equipo) {
		
		super(unaPosicion, equipo);
		
		this.vidaInicial = VIDA_SOLDADO;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_SOLDADO;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_SOLDADO;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_SOLDADO;

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
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}



}
