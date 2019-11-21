package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.unidad.Unidad;
import static fiuba.algo3.algochess.juego.ProveedorConstantes.CURACION_CURANDERO;

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
