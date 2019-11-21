package fiuba.algo3.algochess;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import fiuba.algo3.algochess.modelo.distancia.DistanciaCorta;
import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidad.Curandero;
import fiuba.algo3.algochess.modelo.unidad.Jinete;
import org.junit.Test;

public class CuranderoTest {

	@Test
	public void testCuranderoCuraUnidadAmigaYSeLeSumaLaVidaCorrespondiente() {
		
		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaCorta());
		
		Equipo unEquipoMock = mock(Equipo.class);
		Tablero tablero = mock(Tablero.class);

		Curandero unCuranderoAliado = new Curandero(unaPosicionMock, unEquipoMock);
		Jinete unJineteAliado = new Jinete(otraPosicionMock, unEquipoMock);


		unJineteAliado.recibirDanio(20);
		unCuranderoAliado.atacar(unJineteAliado, tablero);
		
		assertTrue(unJineteAliado.getVidaRestante() == 95);
		
		unJineteAliado.recibirDanio(5);
		unCuranderoAliado.atacar(unJineteAliado, tablero);
		
		assertTrue(unJineteAliado.getVidaRestante() == 100);
	}


}
