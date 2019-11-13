package fiuba.algo3.algochess;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class TableroTest {
	
	@Test
	public void testInicializacionCorrectaDeTablero() {
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		Tablero tablero = new Tablero(8, unEquipoMock, otroEquipoMock);
		
		
		for (int i = 1; i < 9; i++) {
			for (int j = 1; j < 9; j++) {
				Posicion posicion = new Posicion(i,j);
				assertThrows(CasillaLibreException.class, () -> {
					Casilla casilla = tablero.obtenerCasilla(posicion);
					casilla.quitar();
				});
			}
		}
		
	}
	
	@Test
	public void testSeColocaUnidadAliadaEnSectorAliadoConExito() {
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		Tablero tablero = new Tablero(6, unEquipoMock, otroEquipoMock);
		
		Posicion posicion = new Posicion(1,1);
		
		Unidad unidad = new Soldado(posicion, unEquipoMock);
		
		boolean lanzoExcepcion = false;
		
		try { tablero.colocarUnidad(unidad, posicion); }
		catch (CasillaEnemigaException ex) {lanzoExcepcion = true; }
		 		
		assertFalse(lanzoExcepcion);
	}

	@Test
	public void testSeColocaUnidadAliadaEnSectorEnemigoFalla() {
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		Tablero tablero = new Tablero(6, unEquipoMock, otroEquipoMock);

		Unidad unidadMock = mock(Soldado.class);
		when(unidadMock.esAliada(otroEquipoMock)).thenReturn(false);

		Posicion posicion = new Posicion(1,4); //4 = 6/2 + 1 entonces es del equipo jugador2

		Casilla casilla = tablero.obtenerCasilla(posicion);
		
		boolean lanzoExcepcion = false;
		
		try { casilla.colocar(unidadMock); }
		catch (CasillaEnemigaException ex) {lanzoExcepcion = true; }
		 	
		assertTrue(lanzoExcepcion);
	}
	
	@Test
	public void testColocarUnidadEnCasilleroOcupadoFalla() {
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		Tablero tablero = new Tablero(6, unEquipoMock, otroEquipoMock);
		
		Posicion posicion = new Posicion(1,1);
		
		Unidad unaUnidad = new Curandero(posicion, unEquipoMock);
		Unidad otraUnidad = new Soldado(posicion, unEquipoMock);
		
		tablero.colocarUnidad(unaUnidad, posicion);
		
		boolean lanzoExcepcion = false;
		
	
		try { tablero.colocarUnidad(otraUnidad, posicion); } 
		catch (CasillaOcupadaException ex) { lanzoExcepcion = true; }
	
		assertTrue(lanzoExcepcion);
		
	}
}
