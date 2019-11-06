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
		
		Posicion posicionMock = mock(Posicion.class);
		when(posicionMock.hashCode()).thenReturn(5);
		
		tablero.colocarUnidad(unidadMock, posicionMock);
		
		Casilla casilla = tablero.obtenerCasilla(posicionMock);
		
		boolean lanzoExcepcion = false;
		
		try {
			casilla.colocar(unidadMock);
		}
		catch (Exception ex) { //seria invalida si no es del mismo equipo
			lanzoExcepcion = true;
		}
		
		assertFalse(lanzoExcepcion);
	}

}
