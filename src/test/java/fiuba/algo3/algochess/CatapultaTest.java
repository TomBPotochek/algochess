package fiuba.algo3.algochess;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class CatapultaTest {

	@Test
	public void testCatapultaAtacaUnidadEnemigaYSeLeRestaLaVidaCorrespondiente() {
		
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Catapulta unaCatapultaAliada = new Catapulta(unaPosicionMock, "jugador1");
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, "jugador2");
		
		unaCatapultaAliada.atacar(unSoldadoEnemigo, tableroMock);
		
		assertTrue(unSoldadoEnemigo.getVidaRestante() == 80);
	}

}
