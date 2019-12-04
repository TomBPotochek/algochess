package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoCatapultaException;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.excepciones.UnidadDestruidaException;
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
		this.danioAtaqueADistancia = DANIO_DISTANCIA_CATAPULTA;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_CATAPULTA;
		this.arma = new Piedra();
		this.matafuego = new Matafuego();
   }

	@Override
	public void mover(Direccion direccion, Tablero tablero) throws MovimientoInvalidoException {
		throw new MovimientoInvalidoCatapultaException();
	}

	@Override
	public void recibirVida(int vida) {
		throw new AtaqueInvalidoException();
	}

	@Override
	public void atacar(Unidad unidad, Tablero tablero) {
		Distancia distancia = this.obtenerPosicion().calcularDistancia(unidad.obtenerPosicion());
		try {
			distancia.atacar(unidad, this.arma);
			unidad.quemar(tablero, this);
			matafuego.usar();
		} catch (UnidadDestruidaException e) {
			tablero.quitarUnidad(unidad);
			throw e;
		}
	}

	public void agregarAMatafuego(Unidad unidad) {
    	matafuego.agregar(unidad);
	}

	public void usarMatafuego() {
    	matafuego.usar();
	}
	
}