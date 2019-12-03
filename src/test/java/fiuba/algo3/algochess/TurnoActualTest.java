package fiuba.algo3.algochess;

import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Jinete;
import org.junit.Assert;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;

public class TurnoActualTest {

    @Test
    public void test01seMueveUnaUnidadCorrectamente() throws Exception {
        AlgoChess algoChess = new AlgoChess("Equipo1", "Equipo2");
        Posicion pos = new Posicion(2, 2);
        Direccion direccion = Direccion.NE;

        algoChess.getTurnoActual().comprar("Jinete", pos);
        // hago una compra para que sea el turno de Equipo1
        algoChess.getTurnoActual().comprar("Jinete", new Posicion(12,12));
        algoChess.getTurnoActual().mover(pos, direccion);

        Tablero tablero = algoChess.obtenerTablero();

        Assert.assertEquals(tablero.obtenerUnidad(direccion.calcularPosicionSiguiente(pos)).getClass(), Jinete.class);
    }

    @Test
    public void test02intentarMoverUnaCatapultaLanzaExcepcion() throws Exception {
        AlgoChess algoChess = new AlgoChess("Equipo1", "Equipo2");
        Posicion pos = new Posicion(2, 2);
        Direccion direccion = Direccion.NE;

        algoChess.getTurnoActual().comprar("Catapulta", pos);

        assertThrows(MovimientoInvalidoException.class, () -> {
            algoChess.getTurnoActual().mover(pos, direccion);
        });
    }
}
