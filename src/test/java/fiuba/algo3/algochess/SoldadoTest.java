package fiuba.algo3.algochess;


import fiuba.algo3.algochess.model.distancia.DistanciaCorta;
import fiuba.algo3.algochess.model.distancia.DistanciaLarga;
import fiuba.algo3.algochess.model.distancia.DistanciaMedia;
import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Soldado;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class SoldadoTest {

	@Test
	public void testSoldadoAtacaUnidadEnemigaADistanciaCortaYSeLeRestaLaVidaCorrespondiente() {

		Posicion unaPosicion = new Posicion(1,10);
		Posicion otraPosicion = new Posicion(1,11);
		Equipo unEquipo = new Equipo("hola");
		Equipo otroEquipo = new Equipo("chau");
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo);

		Soldado unSoldadoAliado = new Soldado(unaPosicion, unEquipo);
		Soldado unSoldadoEnemigo = new Soldado(otraPosicion, otroEquipo);
		
		tablero.colocarUnidad(unSoldadoAliado, unaPosicion);
		tablero.colocarUnidad(unSoldadoEnemigo, otraPosicion);

		unSoldadoAliado.atacar(otraPosicion, tablero);

		assertEquals(unSoldadoEnemigo.getVidaRestante(), 90, 0);
	}

	@Test
	public void testSoldadoNoPuedeAtacarAEnemigosADistanciaMedia() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaMedia());
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, unEquipoMock);
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, otroEquipoMock);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unSoldadoAliado.atacar(otraPosicionMock, tableroMock);
		});

	}


	@Test
	public void testSoldadoNoPuedeAtacarAEnemigosADistanciaLarga() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Soldado unSoldadoAliado = new Soldado(unaPosicionMock, unEquipoMock);
		Soldado unSoldadoEnemigo = new Soldado(otraPosicionMock, otroEquipoMock);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unSoldadoAliado.atacar(otraPosicionMock, tableroMock);
		});

	}
}
