package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public class NoQuemado extends estaQuemado {

    @Override
    public void quemar(Posicion posicion, float danio, Tablero tablero) {

        tablero.atacar(posicion, danio);
        tablero.obtenerUnidad(posicion).cambiarEstadoQuemado();

        for (Direccion unaDireccion : Direccion.values()) {
            try{
                Unidad unaUnidadContigua = tablero.obtenerUnidad(unaDireccion.calcularPosicionSiguiente(posicion));
                unaUnidadContigua.quemar(danio, tablero);
            } catch (CasillaLibreException e) {}
        }

    }
}
