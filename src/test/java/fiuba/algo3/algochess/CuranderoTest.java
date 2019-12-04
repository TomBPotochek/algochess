package fiuba.algo3.algochess;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

import fiuba.algo3.algochess.model.distancia.DistanciaCorta;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Curandero;
import fiuba.algo3.algochess.model.unidad.Jinete;

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

		when(tablero.obtenerUnidad(otraPosicionMock)).thenReturn(unJineteAliado);

		unJineteAliado.recibirDanio(20);
		unCuranderoAliado.atacar(otraPosicionMock, tablero);
		
		assertTrue(unJineteAliado.getVidaRestante() == 95);
		
		unJineteAliado.recibirDanio(5);
		unCuranderoAliado.atacar(otraPosicionMock, tablero);
		
		assertTrue(unJineteAliado.getVidaRestante() == 100);
	}


}
