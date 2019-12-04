package fiuba.algo3.algochess.model.distancia;

import fiuba.algo3.algochess.model.unidad.Arma;
import fiuba.algo3.algochess.model.unidad.Unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_CORTA_DESDE;
import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_CORTA_HASTA;

public class DistanciaCorta extends Distancia {
	

	public DistanciaCorta() {
		super(DISTANCIA_CORTA_DESDE, DISTANCIA_CORTA_HASTA);
	}

	@Override
	public void atacar(Unidad unidad, Arma arma) {
		arma.ataqueCorto(unidad);
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
