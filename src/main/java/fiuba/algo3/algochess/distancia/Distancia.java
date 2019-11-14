package fiuba.algo3.algochess.distancia;

import fiuba.algo3.algochess.unidad.Atacante;
import fiuba.algo3.algochess.unidad.Unidad;

public abstract class Distancia {
    public abstract void atacar(Atacante atacante, Unidad atacado);
}
