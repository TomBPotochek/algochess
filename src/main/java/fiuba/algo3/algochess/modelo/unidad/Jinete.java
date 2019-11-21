package fiuba.algo3.algochess.modelo.unidad;

import fiuba.algo3.algochess.modelo.distancia.Distancia;
import fiuba.algo3.algochess.modelo.distancia.DistanciaCorta;
import fiuba.algo3.algochess.modelo.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.modelo.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.modelo.juego.ArcoYFlecha;
import fiuba.algo3.algochess.modelo.juego.Arma;
import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Espada;
import fiuba.algo3.algochess.modelo.juego.Posicion;
import fiuba.algo3.algochess.modelo.tablero.EstadoArma;
import fiuba.algo3.algochess.modelo.tablero.EstadoArmaAyF;
import fiuba.algo3.algochess.modelo.tablero.EstadoArmaEspada;
import fiuba.algo3.algochess.modelo.tablero.Tablero;

import java.util.ArrayList;

import static fiuba.algo3.algochess.modelo.juego.ProveedorConstantes.*;

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
		this.setEstado(new EstadoArmaAyF(), new ArcoYFlecha());
	}
	
	public void ponerEspada() {
		this.setEstado(new EstadoArmaEspada(), new Espada());
	}
	
	private void resetEstadoArma() {
		this.setEstado(new EstadoArmaEspada(), new ArcoYFlecha());
		//EstadoArmaEspada se puede cambiar por cualquiera
		//ArcoYFlecha es el arma por default (caso sin aliados cerca ni enemigos cerca)
	}

	
	@Override
	public void atacar(Unidad unidad, Tablero tablero) {
		this.resetEstadoArma();
		
		Distancia distanciaAEnemigo = this.obtenerPosicion().calcularDistancia(unidad.obtenerPosicion());
		Distancia unaDistanciaCorta = new DistanciaCorta();
		ArrayList<Posicion> posicionesCortas = unaDistanciaCorta.obtenerPosicionesCercanas(this.posicion);
		
		for (Posicion posicionTemp : posicionesCortas) {
			try {
				Unidad unidadTemp = tablero.obtenerUnidad(posicionTemp);
				unidadTemp.cambiarEstadoDeUnidad(this);
			} catch (CasillaLibreException e) {
				; //no hace nada
			}
		}
		
		
		try {
			distanciaAEnemigo.atacar(unidad, this.arma);		
		} catch (UnidadDestruidaException e) {
			tablero.quitarUnidad(unidad);
		}
	}
}
