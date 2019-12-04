package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.model.unidad.Soldado;
import fiuba.algo3.algochess.model.unidad.Unidad;


public class UnidadTest {

	@Test
	public void unidadQueAtacaAUnidadEnemigaSobreTerritorioEnemigoquitaDanioNormal() {
		Equipo bueno = new Equipo("bueno");
		Equipo malo = new Equipo("malo");
		Posicion pos1 = new Posicion(1,10);
		Posicion pos2 = new Posicion(1,11);
		Tablero tablero = new Tablero(20, bueno, malo);
		
		
		Unidad soldadoAliado = new Soldado(pos1, bueno);
		Unidad soldadoEnemigo = new Soldado(pos2, malo);
		
		tablero.colocarUnidad(soldadoAliado, pos1);
		tablero.colocarUnidad(soldadoEnemigo, pos2);
		
		soldadoAliado.atacar(pos2, tablero);
		
		assertEquals(soldadoEnemigo.getVidaRestante(), 90 , 0);
	}

	@Test
	public void unidadQueAtacaUnidadEnemigasobreTerritorioAliadoQuitaDanioExtra() {
		Equipo bueno = new Equipo("bueno");
		Equipo malo = new Equipo("malo");
		Posicion pos1 = new Posicion(1,10);
		Posicion pos2 = new Posicion(1,11);
		Tablero tablero = new Tablero(20, bueno, malo);
		
		
		Unidad soldadoAliado = new Soldado(pos1, bueno);
		Unidad soldadoEnemigo = new Soldado(pos2, malo);
		
		tablero.colocarUnidad(soldadoAliado, pos1);
		tablero.colocarUnidad(soldadoEnemigo, pos2);
		Posicion pos3 = new Posicion(2,10);
		tablero.moverUnidad(pos2, pos3);
		
		soldadoAliado.atacar(pos3, tablero);
		
		assertEquals(soldadoEnemigo.getVidaRestante(), 89.5 , 0);
	}	
	
}
