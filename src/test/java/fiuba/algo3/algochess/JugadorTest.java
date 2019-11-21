package fiuba.algo3.algochess;

import fiuba.algo3.algochess.excepciones.PuntosInsuficientesException;
import fiuba.algo3.algochess.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Jugador;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;
import fiuba.algo3.algochess.unidad.Unidad;

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
    
    @Test
    public void test02ElJugadorQueSeQuedaSinUnidadesEsElPerdedor() {

    	Equipo equipoA = new Equipo("A");
    	Equipo equipoB = new Equipo("A");

    	Jugador jugadorGanador = new Jugador(equipoA);
    	Jugador jugadorPerdedor = new Jugador(equipoB);

    	Tablero tablero = new Tablero(20, equipoA, equipoB);

    	Posicion posSoldadoGanador1 = new Posicion(2,10);
    	Posicion posSoldadoGanador2 = new Posicion(5,10);
    	Posicion posSoldadoPerdedor1 = new Posicion(2,11);
    	Posicion posSoldadoPerdedor2 = new Posicion(5,11);

    	jugadorGanador.comprarSoldado(tablero, posSoldadoGanador1);
    	jugadorGanador.comprarSoldado(tablero, posSoldadoGanador2);

    	jugadorPerdedor.comprarSoldado(tablero, posSoldadoPerdedor1);
    	jugadorPerdedor.comprarSoldado(tablero, posSoldadoPerdedor2);

    	@SuppressWarnings("unused")
		Unidad soldadoGanador1 = tablero.obtenerUnidad(posSoldadoGanador1);
		@SuppressWarnings("unused")
		Unidad soldadoGanador2 = tablero.obtenerUnidad(posSoldadoGanador2);

    	for (int i = 0; i < 10; i++) {
    		try {
    			soldadoGanador1.atacar(tablero.obtenerUnidad(posSoldadoPerdedor1), tablero);
    		} catch (UnidadDestruidaException e) {
    			jugadorPerdedor.limpiarUnidadesMuertas();
    		}
    		
    		try {
    			soldadoGanador2.atacar(tablero.obtenerUnidad(posSoldadoPerdedor2), tablero);
    		} catch (UnidadDestruidaException e) {
    			jugadorPerdedor.limpiarUnidadesMuertas();
    		}
    	}
    	

    	assertEquals(jugadorPerdedor.esPerdedor(), true);
    }



}