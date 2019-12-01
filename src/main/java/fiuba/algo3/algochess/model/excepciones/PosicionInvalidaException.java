package fiuba.algo3.algochess.model.excepciones;

import fiuba.algo3.algochess.model.tablero.Posicion;

@SuppressWarnings("serial")
public class PosicionInvalidaException extends ModelException {

	public PosicionInvalidaException(String mensaje) {
		super(mensaje);
	}

	public PosicionInvalidaException() {

	}
}
