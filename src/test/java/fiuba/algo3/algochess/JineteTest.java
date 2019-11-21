package fiuba.algo3.algochess;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import fiuba.algo3.algochess.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidad.Jinete;
import fiuba.algo3.algochess.modelo.unidad.Soldado;
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

		Posicion unaPosicionMock = new Posicion(1,1);
		Posicion otraPosicionMock = new Posicion(20,20);
		Equipo equipoBueno = new Equipo("bueno");
		Equipo equipoMalo = new Equipo("malo");
		Tablero tableroMock = new Tablero(20,equipoBueno, equipoMalo);

		Jinete unJineteAliado = new Jinete(unaPosicionMock, equipoBueno);
		Jinete unJineteEnemigo = new Jinete(otraPosicionMock, equipoMalo);

		assertThrows(AtaqueInvalidoException.class, () -> {

			unJineteAliado.atacar(unJineteEnemigo, tableroMock);
		});

	}

}
