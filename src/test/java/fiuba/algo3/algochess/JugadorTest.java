package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class JugadorTest {
    @Test
    public void test01JugadorPuedeComprarUnidadesHastaQuedarseSinPuntos() {
        Equipo unEquipoMock = mock(Equipo.class);
        Tablero tablero = mock(Tablero.class);
        Posicion posicion = mock(Posicion.class);
        Jugador jugador = new Jugador(unEquipoMock);

        jugador.comprarCatapulta(tablero, posicion); // 5pts
        jugador.comprarCatapulta(tablero, posicion); // 10pts
        jugador.comprarJinete(tablero, posicion); // 13pts
        jugador.comprarCurandero(tablero, posicion); //15pts
        jugador.comprarSoldado(tablero, posicion); // 16pts
        jugador.comprarSoldado(tablero, posicion); // 17pts
        jugador.comprarJinete(tablero, posicion); // 20pts

        assertThrows(PuntosInsuficientesException.class, () -> {
            jugador.comprarCatapulta(tablero, posicion);
        });

    }



}