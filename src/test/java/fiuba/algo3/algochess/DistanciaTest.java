package fiuba.algo3.algochess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import fiuba.algo3.algochess.model.distancia.*;
import fiuba.algo3.algochess.model.tablero.Posicion;

public class DistanciaTest {

	@Test
	public void testDosDistanciasDeMismoTipoSonIguales() {
		Distancia unaDist = new DistanciaCorta();
		Distancia otraDist = new DistanciaCorta();
		
		assertTrue(unaDist.equals(otraDist));
	}
	
	@Test
	public void testDosDistanciasDeDistintoTipoSonDistintas() {
		Distancia unaDist = new DistanciaCorta();
		Distancia otraDist = new DistanciaLarga();
		
		assertFalse(unaDist.equals(otraDist));
	}
	
	@Test
	public void testPosicionesCercanasCalculadasSonDelMismoTipo() {
		Posicion unaPos = new Posicion(3,4);
		Distancia unaDist = new DistanciaMedia();
		
		ArrayList<Posicion> posicionesCercanas = unaDist.obtenerPosicionesCercanas(unaPos);
		
		for (Posicion posTemp : posicionesCercanas) {
			assertTrue(unaPos.calcularDistancia(posTemp).equals(unaDist));
		}
		
	}
}
