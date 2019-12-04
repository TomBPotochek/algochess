package fiuba.algo3.algochess.model.excepciones;

public class AtaqueInvalidoException extends RuntimeException {
	
	public AtaqueInvalidoException() {
		
	}
	
	public AtaqueInvalidoException(String msj) {
		super(msj);
	}
}
