package fiuba.algo3.algochess;

import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class TableroTest {
	
	@Test
	public void testInicializacionCorrectaDeTablero() {
		//necesitaria ver si son aliados o enemigos los casilleros
		fail();
	}
	
	@Test
	public void testSeColocaUnidadAliadaEnSectorAliadoConExito() {
		Tablero tablero = new Tablero(6);
		
		Unidad unidadMock = mock(Soldado.class);
		
		Posicion posicion = new Posicion(1,1);
		
		tablero.colocarUnidad(unidadMock, posicion);
		
		Casilla casilla = tablero.obtenerCasilla(posicion);
		
		boolean lanzoExcepcion = false;
		
		/*
		 * try { casilla.colocar(unidadMock); } catch (CasillaInvalidaException ex) {
		 * //seria invalida si no es del mismo equipo lanzoExcepcion = true; }
		 */		
		assertFalse(lanzoExcepcion);
	}

	@Test
	public void testSeColocaUnidadAliadaEnSectorEnemigoFalla() {
		Tablero tablero = new Tablero(6);
		
		Unidad unidadMock = mock(Soldado.class);
		
		Posicion posicion = new Posicion(1,1);
		
		tablero.colocarUnidad(unidadMock, posicion);
		
		Casilla casilla = tablero.obtenerCasilla(posicion);
		
		boolean lanzoExcepcion = false;
		
		/*
		 * try { casilla.colocar(unidadMock); } catch (CasillaInvalidaException ex) {
		 * //seria invalida si no es del mismo equipo lanzoExcepcion = true; }
		 */		
		assertTrue(lanzoExcepcion);
	}
	
	@Test
	public void testColocarUnidadEnCasilleroOcupadoFalla() {
		Tablero tablero = new Tablero(6);
		
		Unidad unidadMock = mock(Soldado.class);
		Unidad otraUnidad = mock(Soldado.class);
		
		Posicion posicion = new Posicion(1,1);
		
		tablero.colocarUnidad(unidadMock, posicion);
		
		boolean lanzoExcepcion = false;
		
		/*
		 * try { tablero.colocarUnidad(otraUnidad); } catch (CasillaOcupadaException ex)
		 * { lanzoExcepcion = true; }
		 */		
		assertTrue(lanzoExcepcion);
		
	}
}
