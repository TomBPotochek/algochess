package fiuba.algo3.algochess.model.excepciones;

public class MovimientoInvalidoCatapultaException extends MovimientoInvalidoException {
    public MovimientoInvalidoCatapultaException() {
        super("Error: La catapulta no puede moverse");
    }
}
