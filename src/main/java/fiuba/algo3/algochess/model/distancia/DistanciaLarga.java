package fiuba.algo3.algochess.model.distancia;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DISTANCIA_LARGA_DESDE;
import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

import fiuba.algo3.algochess.model.unidad.Arma;

public class DistanciaLarga extends Distancia {
	
	public DistanciaLarga() {
		super(DISTANCIA_LARGA_DESDE, TAMANIO_TABLERO);
	}

	@Override
	public float atacar(Arma arma) {
		return arma.ataqueLargo();
		
	}
	
	@Override
    public boolean equals(Object obj) {
    	if (this == obj)
    		return true;
    	if (obj instanceof DistanciaLarga)
    		return true;
    	else return false;
    }
	
}
