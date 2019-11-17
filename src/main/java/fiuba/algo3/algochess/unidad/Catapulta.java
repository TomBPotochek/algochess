package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

public class Catapulta extends UnidadAtacante {
    public Catapulta(Posicion unaPosicion, Equipo equipo) {

    	super(unaPosicion, equipo);
  
    	this.vidaInicial = VIDA_CATAPULTA;
        this.vidaRestante = vidaInicial;
        this.costo = COSTO_CATAPULTA;
		this.posicion = unaPosicion;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_CATAPULTA;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_CATAPULTA;
   }

	@Override
	public void atacarADistanciaCorta(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaMedia(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
    	// hay atacar recursivamente a las unidades contiguas
		unaUnidad.recibirDanio(danioAtaqueADistancia);
	}
}