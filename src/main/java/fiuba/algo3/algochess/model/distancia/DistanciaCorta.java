package fiuba.algo3.algochess.model.distancia;

import fiuba.algo3.algochess.model.unidad.Arma;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_CORTA_DESDE;
import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_CORTA_HASTA;

public class DistanciaCorta extends Distancia {
	

	public DistanciaCorta() {
		super(DISTANCIA_CORTA_DESDE, DISTANCIA_CORTA_HASTA);
	}

	@Override
	public float atacar(Arma arma) {
		return arma.ataqueCorto();
	}
	
	@Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj instanceof DistanciaCorta)
    		return true;
    	else return false;
    }

}
