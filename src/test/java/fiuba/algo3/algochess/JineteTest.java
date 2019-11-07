package fiuba.algo3.algochess;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class JineteTest {

	@Test
	public void testJineteAtacaUnidadEnemigaADistanciaCortaYSeLeRestaLaVidaCorrespondiente() {
		
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaCorta());
		Jinete unJineteAliado = new Jinete(unaPosicionMock, "jugador1");
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock, "jugador2");
		
		unJineteAliado.atacar(unJineteEnemigo, tableroMock);
		
		assertEquals(unJineteEnemigo.getVidaRestante(), 95);
	}

	@Test
	public void testJineteAtacaUnidadEnemigaADistanciaMediaYSeLeRestaLaVidaCorrespondiente() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaMedia());
		Jinete unJineteAliado = new Jinete(unaPosicionMock, "jugador1");
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock, "jugador2");

		unJineteAliado.atacar(unJineteEnemigo, tableroMock);

		assertEquals(unJineteEnemigo.getVidaRestante(),85);
	}

	@Test
	public void testJineteNoPuedeAtacarAEnemigosADistanciaLarga() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Jinete unJineteAliado = new Jinete(unaPosicionMock, "jugador1");
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock, "jugador2");

		assertThrows(AtaqueInvalidoException.class, () -> {

			unJineteAliado.atacar(unJineteEnemigo, tableroMock);
		});

	}

}
