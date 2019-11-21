package fiuba.algo3.algochess.modelo.distancia;

import fiuba.algo3.algochess.modelo.juego.Arma;
import fiuba.algo3.algochess.modelo.unidad.Unidad;
import static fiuba.algo3.algochess.modelo.juego.ProveedorConstantes.TAMANIO_TABLERO;

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
