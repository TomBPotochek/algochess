package fiuba.algo3.algochess.model.excepciones;

import fiuba.algo3.algochess.model.tablero.Posicion;

@SuppressWarnings("serial")
public class PosicionInvalidaException extends ModelException {

	public PosicionInvalidaException() {
		super("Error: Posicion invalida");
	}

	public PosicionInvalidaException(String string) {
		super(string);
	}
}
