package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.excepciones.PosicionFueraDeRangoException;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Tablero;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_DISTANCIA_CATAPULTA;

public class NoQuemado extends estaQuemado {

    @Override
    public void quemar(Unidad unaUnidad, Tablero tablero, Catapulta catapulta) {

        unaUnidad.recibirDanio(DANIO_DISTANCIA_CATAPULTA);
        unaUnidad.cambiarEstadoQuemado();

        for (Direccion unaDireccion : Direccion.values()) {
            try{
                Unidad unaUnidadContigua = tablero.obtenerUnidad(unaDireccion.calcularPosicionSiguiente(unaUnidad.obtenerPosicion()));
                unaUnidadContigua.quemar(tablero, catapulta);
            } catch (CasillaLibreException | PosicionFueraDeRangoException e) {}
        }

    }
}
