package fiuba.algo3.algochess;

public class DistanciaCorta extends Distancia {
    public void atacar(Atacante atacante, Unidad atacado) {
        atacante.atacarADistanciaCorta(atacado);
    }
}
