package fiuba.algo3.algochess.model.excepciones;


public class AtaqueInvalidoException extends ModelException {

    public AtaqueInvalidoException() {
        super("Ataque invalido");
    }
    
    public AtaqueInvalidoException(String msj) {
    	super(msj);
    }
    
}

