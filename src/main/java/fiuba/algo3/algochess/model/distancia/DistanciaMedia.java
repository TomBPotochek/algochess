package fiuba.algo3.algochess.model.distancia;

import fiuba.algo3.algochess.model.unidad.Arma;

public class DistanciaMedia extends Distancia {
	
	public DistanciaMedia() {
		super(3,5);
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
