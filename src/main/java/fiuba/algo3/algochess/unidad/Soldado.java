package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

public class Soldado extends AtacanteMovible {

	public Soldado(Posicion unaPosicion, Equipo equipo) {
		
		super(unaPosicion, equipo);
		
		this.vidaInicial = VIDA_SOLDADO;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_SOLDADO;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_SOLDADO;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_SOLDADO;

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
