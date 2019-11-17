package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

public class Jinete extends AtacanteMovible {
    public Jinete(Posicion unaPosicion, Equipo equipo) {
    	
    	super(unaPosicion, equipo);
    	
		this.vidaInicial = VIDA_JINETE;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_JINETE;
	    this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_JINETE;
	    this.danioAtaqueADistancia = DANIO_DISTANCIA_JINETE;
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
