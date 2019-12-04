package fiuba.algo3.algochess.model.excepciones;

public class CasillaEnemigaException extends ModelException {

    public CasillaEnemigaException() {
        super("Error: No se puede ubicar unidades en campo enemigo");
    }
}
