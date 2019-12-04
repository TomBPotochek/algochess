package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public class Curandero extends UnidadMovible {
    //private int curacion;

    public Curandero(Posicion unaPosicion, Equipo equipo) {
    	super(unaPosicion, equipo);

    	this.vidaInicial = VIDA_CURANDERO;
    	this.vidaRestante = vidaInicial;
    	this.costo = COSTO_CURANDERO;
    	this.arma = new Medikit();
    }

    @Override
	public void atacar(Posicion posicion, Tablero tablero) throws AtaqueInvalidoException{
		Distancia dist = this.posicion.calcularDistancia(posicion);
		float curacion = dist.atacar(this.arma);
		Unidad unidad = tablero.obtenerUnidad(posicion);
		if (unidad.esAliada(this.equipo))
			unidad.recibirVida(curacion);
		else throw new AtaqueInvalidoException("Solo podes curar unidades aliadas");
	}

}
