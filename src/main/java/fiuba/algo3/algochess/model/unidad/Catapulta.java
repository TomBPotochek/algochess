package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public class Catapulta extends Unidad {
    public Catapulta(Posicion unaPosicion, Equipo equipo) {

    	super(unaPosicion, equipo);
  
    	this.vidaInicial = VIDA_CATAPULTA;
        this.vidaRestante = vidaInicial;
        this.costo = COSTO_CATAPULTA;
		this.posicion = unaPosicion;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_CATAPULTA;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_CATAPULTA;
		this.arma = new Piedra();
   }

	@Override
	public void recibirVida(int vida) {
		throw new AtaqueInvalidoException();
	}
	
}