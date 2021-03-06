package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoCatapultaException;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public class Catapulta extends Unidad {

	private Matafuego matafuego;

    public Catapulta(Posicion unaPosicion, Equipo equipo) {

    	super(unaPosicion, equipo);
  
    	this.vidaInicial = VIDA_CATAPULTA;
        this.vidaRestante = vidaInicial;
        this.costo = COSTO_CATAPULTA;
		this.posicion = unaPosicion;
		this.arma = new Piedra();
		this.matafuego = new Matafuego();
   }

	@Override
	public void mover(Direccion direccion, Tablero tablero) throws MovimientoInvalidoException {
		throw new MovimientoInvalidoCatapultaException();
	}

	@Override
	public void recibirVida(float vida) {
		throw new AtaqueInvalidoException();
	}

	@Override
	public void atacar(Posicion posicion, Tablero tablero) {
		Distancia distancia = this.obtenerPosicion().calcularDistancia(posicion);
		float danio = distancia.atacar(this.arma);
		Unidad unidad = tablero.obtenerUnidad(posicion);
		unidad.quemar(danio, tablero, this);
		this.matafuego.usar();
	}

	public void agregarAMatafuego(Unidad unidad) {
    	this.matafuego.agregar(unidad);
	}

	public void usarMatafuego() {
    	this.matafuego.usar();
	}
	
}