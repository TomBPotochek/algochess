package fiuba.algo3.algochess;

import static fiuba.algo3.algochess.ProveedorConstantes.*;

public class Curandero extends UnidadMovible {
    private int curacion;

    public Curandero(Posicion unaPosicion, Equipo equipo) {
    	super(unaPosicion, equipo);

    	this.curacion = CURACION_CURANDERO;
    	this.vidaInicial = VIDA_CURANDERO;
    	this.vidaRestante = vidaInicial;
    	this.costo = COSTO_CURANDERO;
    }

    //y si no es movible?
	public void curar(UnidadMovible unidadAliada) {
		
		unidadAliada.recibirVida(this.curacion);
		
	}

}
