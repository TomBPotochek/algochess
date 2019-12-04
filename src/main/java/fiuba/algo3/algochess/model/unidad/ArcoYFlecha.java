package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_DISTANCIA_JINETE;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public class ArcoYFlecha implements Arma {

	@Override
	public float ataqueCorto() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

	@Override
	public float ataqueMedio() {
		//unaUnidad.recibirDanio(DANIO_DISTANCIA_JINETE);
		return DANIO_DISTANCIA_JINETE;
		
	}

	@Override
	public float ataqueLargo() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

}
