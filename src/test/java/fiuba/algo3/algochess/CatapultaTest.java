package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import fiuba.algo3.algochess.model.distancia.DistanciaCorta;
import fiuba.algo3.algochess.model.distancia.DistanciaLarga;
import fiuba.algo3.algochess.model.distancia.DistanciaMedia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Catapulta;

import org.junit.Test;

public class CatapultaTest {

	@Test
	public void testCatapultaNoPuedeAtacarAEnemigosADistanciaCorta() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaCorta());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, unEquipoMock);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, otroEquipoMock);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);
		});
	}

	@Test
	public void testCatapultaNoPuedeAtacarAEnemigosADistanciaMedia() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaMedia());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, unEquipoMock);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, otroEquipoMock);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);
		});

	}

	@Test
	public void testCatapultaAtacaUnidadEnemigaADistanciaLargaYSeLeRestaLaVidaCorrespondiente() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Catapulta unCatapultaAliado = new Catapulta(unaPosicionMock, unEquipoMock);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicionMock, otroEquipoMock);

		unCatapultaAliado.atacar(unCatapultaEnemigo, tableroMock);

		assertEquals(unCatapultaEnemigo.getVidaRestante(), 30);
	}

}
