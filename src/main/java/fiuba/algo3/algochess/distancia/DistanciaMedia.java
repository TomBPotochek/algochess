package fiuba.algo3.algochess.distancia;

import fiuba.algo3.algochess.juego.Arma;
import fiuba.algo3.algochess.unidad.Unidad;

public class DistanciaMedia extends Distancia {
	
	public DistanciaMedia() {
		super(3,5);
	}

	@Override
	public void atacar(Unidad unidad, Arma arma) {
		arma.ataqueMedio(unidad);
		
	}
	
	@Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj instanceof DistanciaMedia)
    		return true;
    	else return false;
    }
}
