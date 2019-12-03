package fiuba.algo3.algochess.model.excepciones;

public class PosicionFueraDeRangoException extends PosicionInvalidaException {
    public PosicionFueraDeRangoException() {
        super("Error: Posicion fuera de rango");
    }
}
