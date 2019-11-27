package fiuba.algo3.algochess.model.distancia;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.TAMANIO_TABLERO;

import fiuba.algo3.algochess.model.unidad.Arma;
import fiuba.algo3.algochess.model.unidad.Unidad;

public class DistanciaLarga extends Distancia {
	
	public DistanciaLarga() {
		super(6, TAMANIO_TABLERO);
	}

	@Override
	public void atacar(Unidad unidad, Arma arma) {
		arma.ataqueLargo(unidad);
		
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
