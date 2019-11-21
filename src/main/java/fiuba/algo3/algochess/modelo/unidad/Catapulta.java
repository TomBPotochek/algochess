package fiuba.algo3.algochess.modelo.unidad;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Piedra;
import fiuba.algo3.algochess.modelo.juego.Posicion;

import static fiuba.algo3.algochess.modelo.juego.ProveedorConstantes.*;

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


	
}