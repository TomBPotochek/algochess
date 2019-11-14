package fiuba.algo3.algochess.distancia;

import fiuba.algo3.algochess.unidad.Atacante;
import fiuba.algo3.algochess.unidad.Unidad;

public class DistanciaMedia extends Distancia {
    public void atacar(Atacante atacante, Unidad atacado) {
        atacante.atacarADistanciaMedia(atacado);
    }
}
