package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Medikit;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.distancia.Distancia;

public class Curandero extends UnidadMovible {
    private int curacion;

    public Curandero(Posicion unaPosicion, Equipo equipo) {
    	super(unaPosicion, equipo);

    	//this.curacion = CURACION_CURANDERO;
    	this.vidaInicial = VIDA_CURANDERO;
    	this.vidaRestante = vidaInicial;
    	this.costo = COSTO_CURANDERO;
    	this.arma = new Medikit();
    }

    @Override //hay que tener en cuenta que el curar de curandero es atacar, pero no puede curar enemigos
	public void atacar(Unidad unidad, Tablero tablero) {
		Distancia dist = this.posicion.calcularDistancia(unidad.obtenerPosicion());
		if (unidad.esAliada(this.equipo))
			dist.atacar(unidad, this.arma);
		//else throw new Exception(); //casillaEnemigaException?
	}

}
