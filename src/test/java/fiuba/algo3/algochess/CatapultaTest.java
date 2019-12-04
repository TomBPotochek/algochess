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

import fiuba.algo3.algochess.model.unidad.Curandero;
import fiuba.algo3.algochess.model.unidad.Soldado;
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

		Posicion unaPosicion = new Posicion(2, 3);
		Posicion otraPosicion = new Posicion(7, 9);
		Equipo unEquipo = new Equipo("equipo1");
		Equipo otroEquipo = new Equipo("equipo2");
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo) ;
		Catapulta unCatapultaAliado = new Catapulta(unaPosicion, unEquipo);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicion, otroEquipo);
		unCatapultaAliado.atacar(unCatapultaEnemigo, tablero);
		assertEquals(unCatapultaEnemigo.getVidaRestante(), 30);
	}

	@Test
	public void testCatapultaNoPuedeRecibirVida() {
		Posicion unaPosicion = mock(Posicion.class);
		Equipo unEquipo = mock(Equipo.class);
		Posicion otraPosicion = mock(Posicion.class);
		Tablero tablero = mock(Tablero.class);

		Curandero unCurandero = new Curandero(unaPosicion, unEquipo);
		Catapulta unaCatapulta = new Catapulta(otraPosicion, unEquipo);

		when(unaPosicion.calcularDistancia(otraPosicion)).thenReturn(new DistanciaCorta());

		assertThrows(AtaqueInvalidoException.class, () -> {

			unCurandero.atacar(unaCatapulta, tablero);
		});

	}

	@Test
	public void testCatapultaQuemaALosDemasSiEstanContiguos() {

		Posicion unaPosicion = new Posicion(2, 3);
		Posicion otraPosicion = new Posicion(18, 18);
		Posicion segundaPosicion = new Posicion(17, 18);
		Posicion terceraPosicion = new Posicion(17, 17);
		Equipo unEquipo = new Equipo("equipo1");
		Equipo otroEquipo = new Equipo("equipo2");
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo) ;
		Catapulta unCatapultaAliado = new Catapulta(unaPosicion, unEquipo);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicion, otroEquipo);
		Soldado unSoldadoEnemigo = new Soldado(segundaPosicion, otroEquipo);
		Soldado otroSoldadoEnemigo = new Soldado(terceraPosicion, otroEquipo);
		tablero.colocarUnidad(unCatapultaEnemigo,otraPosicion);
		tablero.colocarUnidad(unSoldadoEnemigo, segundaPosicion);
		tablero.colocarUnidad(otroSoldadoEnemigo, terceraPosicion);
		unCatapultaAliado.atacar(unCatapultaEnemigo, tablero);

		assertEquals(otroSoldadoEnemigo.getVidaRestante(), 80);

	}

	@Test
	public void testCatapultaSoloQuemaUnaVezAUnaUnidadEnemiga() {

		Posicion unaPosicion = new Posicion(2, 3);
		Posicion otraPosicion = new Posicion(17, 19);
		Posicion segundaPosicion = new Posicion(17, 18);
		Posicion terceraPosicion = new Posicion(17, 17);
		Equipo unEquipo = new Equipo("equipo1");
		Equipo otroEquipo = new Equipo("equipo2");
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo) ;
		Catapulta unCatapultaAliado = new Catapulta(unaPosicion, unEquipo);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicion, otroEquipo);
		Soldado unSoldadoEnemigo = new Soldado(segundaPosicion, otroEquipo);
		Soldado otroSoldadoEnemigo = new Soldado(terceraPosicion, otroEquipo);
		tablero.colocarUnidad(unCatapultaEnemigo,otraPosicion);
		tablero.colocarUnidad(unSoldadoEnemigo, segundaPosicion);
		tablero.colocarUnidad(otroSoldadoEnemigo, terceraPosicion);
		unCatapultaAliado.atacar(unCatapultaEnemigo, tablero);

		assertEquals(unCatapultaEnemigo.getVidaRestante(), 30);

	}

	@Test
	public void testCatapultaQuemaDosTurnosSeguidosAUnaUnidadEnemiga() {

		Posicion unaPosicion = new Posicion(2, 3);
		Posicion otraPosicion = new Posicion(17, 19);
		Posicion segundaPosicion = new Posicion(17, 18);
		Posicion terceraPosicion = new Posicion(17, 17);
		Equipo unEquipo = new Equipo("equipo1");
		Equipo otroEquipo = new Equipo("equipo2");
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo) ;
		Catapulta unCatapultaAliado = new Catapulta(unaPosicion, unEquipo);
		Catapulta unCatapultaEnemigo = new Catapulta(otraPosicion, otroEquipo);
		Soldado unSoldadoEnemigo = new Soldado(segundaPosicion, otroEquipo);
		Soldado otroSoldadoEnemigo = new Soldado(terceraPosicion, otroEquipo);
		tablero.colocarUnidad(unCatapultaEnemigo,otraPosicion);
		tablero.colocarUnidad(unSoldadoEnemigo, segundaPosicion);
		tablero.colocarUnidad(otroSoldadoEnemigo, terceraPosicion);
		unCatapultaAliado.atacar(unCatapultaEnemigo, tablero);
		unCatapultaAliado.atacar(unCatapultaEnemigo, tablero);

		assertEquals(unCatapultaEnemigo.getVidaRestante(), 10);

	}

}
