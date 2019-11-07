package fiuba.algo3.algochess;


import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class JineteTest {

	@Test
	public void testJineteAtacaUnidadEnemigaYSeLeRestaLaVidaCorrespondiente() {
		
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Jinete unJineteAliado = new Jinete(unaPosicionMock);
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock);
		
		unJineteAliado.atacar(unJineteEnemigo, tableroMock);
		
		assertTrue(unJineteEnemigo.getVidaRestante() == 95);
	}

}
