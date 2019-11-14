package fiuba.algo3.algochess.distancia;

import fiuba.algo3.algochess.unidad.Atacante;
import fiuba.algo3.algochess.unidad.Unidad;

public class DistanciaCorta extends Distancia {
    public void atacar(Atacante atacante, Unidad atacado) {
        atacante.atacarADistanciaCorta(atacado);
    }
}
