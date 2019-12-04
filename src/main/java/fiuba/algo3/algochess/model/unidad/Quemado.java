package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.excepciones.UnidadQuemadaException;

public class Quemado extends estaQuemado {

    @Override
    public void quemar(Posicion posicion, float danio, Tablero tablero) {
        throw new UnidadQuemadaException();

    }
}
