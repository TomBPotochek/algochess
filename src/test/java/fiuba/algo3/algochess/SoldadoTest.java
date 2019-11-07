package fiuba.algo3.algochess;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SoldadoTest {

//	@Test
//	public void testSoldadoAtacaUnidadEnemigaYSeLeRestaLaVidaCorrespondiente() {
//		Posicion unaPosicionMock = mock(Posicion.class);
//		Posicion otraPosicionMock = mock(Posicion.class);
//		Tablero tableroMock = mock(Tablero.class);
//		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, "jugador1");
//		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");
//
//		unSoldadoAliado.atacar(unSoldadoEnemigo, tableroMock);
//
//		assertTrue(unSoldadoEnemigo.getVidaRestante() == 90);
//	}
	@Test
	public void testSoldadoAtacaUnidadEnemigaADistanciaCortaYSeLeRestaLaVidaCorrespondiente() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaCorta());
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, "jugador1");
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");

		unSoldadoAliado.atacar(unSoldadoEnemigo, tableroMock);

		assertEquals(unSoldadoEnemigo.getVidaRestante(), 90);
	}

	@Test
	public void testSoldadoNoPuedeAtacarAEnemigosADistanciaMedia() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaMedia());
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, "jugador1");
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");

		assertThrows(AtaqueInvalidoException.class, () -> {

			unSoldadoAliado.atacar(unSoldadoEnemigo, tableroMock);
		});

	}


	@Test
	public void testSoldadoNoPuedeAtacarAEnemigosADistanciaLarga() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, "jugador1");
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");

		assertThrows(AtaqueInvalidoException.class, () -> {

			unSoldadoAliado.atacar(unSoldadoEnemigo, tableroMock);
		});

	}

}
