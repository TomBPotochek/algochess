package fiuba.algo3.algochess;

public class UnidadMovible extends Unidad {

    public void mover(Direccion direccion, Tablero tablero) {
        Posicion posicionSiguiente = direccion.calcularSiguientePosicion(posicion);
        tablero.colocarUnidadEnPosicion(this, posicionSiguiente);
        this.setPosicion(posicionSiguiente);
    }

    public void setPosicion(Posicion posicionNueva) {
        posicion = posicionNueva;
    }


}
