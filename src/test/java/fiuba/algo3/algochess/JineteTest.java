package fiuba.algo3.algochess;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import fiuba.algo3.algochess.distancia.DistanciaCorta;
import fiuba.algo3.algochess.distancia.DistanciaLarga;
import fiuba.algo3.algochess.distancia.DistanciaMedia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;
import fiuba.algo3.algochess.unidad.Jinete;
import fiuba.algo3.algochess.unidad.Soldado;
import org.junit.Test;

public class JineteTest {

	@Test
	public void testHayEnemigoEnDistanciaCercanaYNoHaySoldadosAliadosEnDistanciaCercanaEntoncesJineteAtacaConEspada() {
		
		Posicion posicion = new Posicion(2,10);
		Posicion otraPosicion = new Posicion(2,11); //campo enemigo
		Equipo equipoBueno = new Equipo("bueno");
		Equipo equipoMalo = new Equipo("malo");
		Tablero tablero = new Tablero(20,equipoBueno, equipoMalo);
		Jinete jineteBueno = new Jinete(posicion, equipoBueno);
		Jinete jineteMalo = new Jinete(otraPosicion, equipoMalo);
		tablero.colocarUnidad(jineteBueno, posicion);
		tablero.colocarUnidad(jineteMalo, otraPosicion);
		
		jineteBueno.atacar(jineteMalo, tablero);

		assertEquals(jineteMalo.getVidaRestante(), 95);
	}

	@Test
	public void testHayUnSoldadoAliadoCercaAtacaEnemigoADistanciaMediaConArcoYFlecha() {
		
		Posicion posicion = new Posicion(2,10);
		Posicion otraPosicion = new Posicion(2,14); //3 a 5 es Distancia Media
		Posicion otraPos = new Posicion(3,10);
		Equipo equipoBueno = new Equipo("bueno");
		Equipo equipoMalo = new Equipo("malo");
		Tablero tablero = new Tablero(20,equipoBueno, equipoMalo);
		Jinete jineteBueno = new Jinete(posicion, equipoBueno);
		Jinete jineteMalo = new Jinete(otraPosicion, equipoMalo);
		Soldado soldadoBueno = new Soldado(otraPos, equipoBueno);
		tablero.colocarUnidad(jineteBueno, posicion);
		tablero.colocarUnidad(jineteMalo, otraPosicion);
		tablero.colocarUnidad(soldadoBueno, otraPos);
		
		jineteBueno.atacar(jineteMalo, tablero);

		assertEquals(jineteMalo.getVidaRestante(),85);
	}
	
	
	@Test
	public void testSoloHayEnemigosEnDistanciaMediaJineteAtacaConArcoYFlecha() {
		Posicion posicion = new Posicion(2,10);
		Posicion otraPosicion = new Posicion(2,14);
		Equipo equipoBueno = new Equipo("bueno");
		Equipo equipoMalo = new Equipo("malo");
		Tablero tablero = new Tablero(20,equipoBueno, equipoMalo);
		Jinete jineteBueno = new Jinete(posicion, equipoBueno);
		Jinete jineteMalo = new Jinete(otraPosicion, equipoMalo);
		tablero.colocarUnidad(jineteBueno, posicion);
		tablero.colocarUnidad(jineteMalo, otraPosicion);
		
		jineteBueno.atacar(jineteMalo, tablero);
		
		assertEquals(jineteMalo.getVidaRestante(),85);
	}
	
	@Test
	public void testHaySoldadosAliadosCercaYHayEnemigosCercaNoPuedeAtacarAEsosEnemigos() {
		
		Posicion posicion = new Posicion(2,10);
		Posicion otraPosicion = new Posicion(2,11);
		Posicion otraPos = new Posicion(3,10);
		Equipo equipoBueno = new Equipo("bueno");
		Equipo equipoMalo = new Equipo("malo");
		Tablero tablero = new Tablero(20,equipoBueno, equipoMalo);
		Jinete jineteBueno = new Jinete(posicion, equipoBueno);
		Jinete jineteMalo = new Jinete(otraPosicion, equipoMalo);
		Soldado soldadoBueno = new Soldado(otraPos, equipoBueno);
		tablero.colocarUnidad(jineteBueno, posicion);
		tablero.colocarUnidad(jineteMalo, otraPosicion);
		tablero.colocarUnidad(soldadoBueno, otraPos);
		
		assertThrows(AtaqueInvalidoException.class, () -> {
			jineteBueno.atacar(jineteMalo, tablero);			
		});
	}

	@Test
	public void testJineteNoPuedeAtacarAEnemigosADistanciaLarga() {

		Posicion unaPosicionMock = mock(Posicion.class);
		Posicion otraPosicionMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
		Equipo otroEquipoMock = mock(Equipo.class);
		when(unaPosicionMock.calcularDistancia(otraPosicionMock)).thenReturn(new DistanciaLarga());
		Jinete unJineteAliado = new Jinete(unaPosicionMock, unEquipoMock);
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock, otroEquipoMock);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unJineteAliado.atacar(unJineteEnemigo, tableroMock);
		});

	}

}
