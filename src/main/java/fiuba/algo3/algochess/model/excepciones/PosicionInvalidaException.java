package fiuba.algo3.algochess.model.excepciones;

@SuppressWarnings("serial")
public class PosicionInvalidaException extends RuntimeException {

	public PosicionInvalidaException(String mensaje) {
		
		super(mensaje);
	}
}