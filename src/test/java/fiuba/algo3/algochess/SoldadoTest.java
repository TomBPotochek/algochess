package fiuba.algo3.algochess;


import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class SoldadoTest {

	@Test
	public void testSoldadoAtacaUnidadEnemigaYSeLeRestaLaVidaCorrespondiente() {
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, "jugador1");
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");
		
		unSoldadoAliado.atacar(unSoldadoEnemigo, tableroMock);
		
		assertTrue(unSoldadoEnemigo.getVidaRestante() == 90);
	}

}
