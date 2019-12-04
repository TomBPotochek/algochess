package fiuba.algo3.algochess.model.distancia;

import fiuba.algo3.algochess.model.unidad.Arma;

public class DistanciaCorta extends Distancia {
	

	public DistanciaCorta() {
		super(1, 2);
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
