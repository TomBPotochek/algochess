package fiuba.algo3.algochess.model.excepciones;

@SuppressWarnings("serial")
public class MovimientoInvalidoException extends ModelException {
	public MovimientoInvalidoException(String string) {
		super(string);
	}
	public MovimientoInvalidoException() {
		super("Movimiento invalido");
	}
}
