package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public abstract class estaQuemado {

    abstract public void quemar(Posicion posicion, float danio, Tablero tablero, Catapulta catapulta);

}
