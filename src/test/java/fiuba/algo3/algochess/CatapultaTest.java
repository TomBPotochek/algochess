package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class CatapultaTest {

	@Test
	public void testCatapultaNoPuedeAtacarAEnemigosADistanciaCorta() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaCorta());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, "jugador1");
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, "jugador2");

		assertThrows(AtaqueInvalidoException.class, () -> {

			unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);
		});
	}

	@Test
	public void testCatapultaNoPuedeAtacarAEnemigosADistanciaMedia() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaMedia());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, "jugador1");
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, "jugador2");

		assertThrows(AtaqueInvalidoException.class, () -> {

			unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);
		});

	}

	@Test
	public void testCatapultaAtacaUnidadEnemigaADistanciaLargaYSeLeRestaLaVidaCorrespondiente() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, "jugador1");
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, "jugador2");

		unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);

		assertEquals(unCatapultaEnemigo.getVidaRestante(), 30);
	}

}
