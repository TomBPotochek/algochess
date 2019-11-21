package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.juego.Arma;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Espada;
import fiuba.algo3.algochess.juego.PortaArma;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.EstadoArma;
import fiuba.algo3.algochess.tablero.EstadoArmaEspada;
import fiuba.algo3.algochess.tablero.Tablero;

import java.util.ArrayList;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

public class Jinete extends UnidadMovible {
	
	private EstadoArma estadoArma;
	
    public Jinete(Posicion unaPosicion, Equipo equipo) {
    	
    	super(unaPosicion, equipo);
    	
		this.vidaInicial = VIDA_JINETE;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_JINETE;
		/*
	    this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_JINETE;
	    this.danioAtaqueADistancia = DANIO_DISTANCIA_JINETE;
	    */
		this.estadoArma = new EstadoArmaEspada();
		
    }
    /*

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
	}*/
	
	public void setEstado(EstadoArma estadoArma, Arma arma) {
		this.estadoArma = estadoArma;
		this.arma = arma;
	}
	
	public void ponerAyF() {
		this.estadoArma.ponerAyF(this);
	}
	
	public void ponerEspada() {
		this.estadoArma.ponerEspada(this);
	}
	
	private void resetEstadoArma() {
		this.setEstado(new EstadoArmaEspada(), new Espada());
	}

	
	@Override
	public void atacar(Unidad unidad, Tablero tablero) {
		this.resetEstadoArma();
		
		Distancia distancia = this.obtenerPosicion().calcularDistancia(unidad.obtenerPosicion());
		ArrayList<Posicion> posicionesCortas = distancia.obtenerPosicionesCercanas(this.posicion);
		
		for (Posicion posicionTemp : posicionesCortas) {
			try {
				Unidad unidadTemp = tablero.obtenerUnidad(posicionTemp);
				unidadTemp.cambiarEstadoDeUnidad(this);
			} catch (CasillaLibreException e) {
				; //no hace nada
			}
		}
		
		
		try {
			distancia.atacar(unidad, this.arma);		
		} catch (UnidadDestruidaException e) {
			tablero.quitarUnidad(unidad);
		}
	}
}
