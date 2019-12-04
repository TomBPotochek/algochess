package fiuba.algo3.algochess.model.distancia;

import fiuba.algo3.algochess.model.unidad.Arma;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_MEDIA_DESDE;
import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_MEDIA_HASTA;

public class DistanciaMedia extends Distancia {
	
	public DistanciaMedia() {
		super(DISTANCIA_MEDIA_DESDE, DISTANCIA_MEDIA_HASTA);
	}

	@Override
	public float atacar(Arma arma) {
		return arma.ataqueMedio();
		
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
