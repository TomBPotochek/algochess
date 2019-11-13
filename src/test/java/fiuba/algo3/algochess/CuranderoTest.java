package fiuba.algo3.algochess;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

public class CuranderoTest {

	@Test
	public void testCuranderoCuraUnidadAmigaYSeLeSumaLaVidaCorrespondiente() {
		
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Equipo unEquipoMock = mock(Equipo.class);

		Curandero unCuranderoAliado = new Curandero(unaPosicionMock, unEquipoMock);
		Jinete unJineteAliado = new Jinete(otraPosicionMock, unEquipoMock);

		unJineteAliado.recibirDanio(20);
		unCuranderoAliado.curar(unJineteAliado);
		
		assertTrue(unJineteAliado.getVidaRestante() == 95);
		
		unJineteAliado.recibirDanio(5);
		unCuranderoAliado.curar(unJineteAliado);
		
		assertTrue(unJineteAliado.getVidaRestante() == 100);
	}


}
