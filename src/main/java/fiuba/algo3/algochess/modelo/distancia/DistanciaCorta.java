package fiuba.algo3.algochess.modelo.distancia;

import fiuba.algo3.algochess.modelo.juego.Arma;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

public class DistanciaCorta extends Distancia {
	

	public DistanciaCorta() {
		super(1, 2);
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
