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
		Catapulta unaCatapultaAliada = new Catapulta(unaPosicionMock);
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock);
		
		unaCatapultaAliada.atacar(unSoldadoEnemigo, tableroMock);
		
		assertTrue(unSoldadoEnemigo.getVidaRestante() == 80);
	}

}
