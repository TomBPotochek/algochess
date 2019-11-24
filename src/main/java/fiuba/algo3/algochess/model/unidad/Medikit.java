package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.CURACION_CURANDERO;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public class Medikit implements Arma {

	@Override
	public void ataqueCorto(Unidad unaUnidad) {
		unaUnidad.recibirVida(CURACION_CURANDERO);

	}

	@Override
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

}
