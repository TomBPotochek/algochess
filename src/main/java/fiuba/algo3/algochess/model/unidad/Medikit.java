package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.CURACION_CURANDERO;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public class Medikit implements Arma {

	@Override
	public float ataqueCorto() {
		//unaUnidad.recibirVida(CURACION_CURANDERO);
		return CURACION_CURANDERO;

	}

	@Override
	public float ataqueMedio() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public float ataqueLargo() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

}
