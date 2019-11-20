package fiuba.algo3.algochess;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import fiuba.algo3.algochess.juego.Posicion;

import static org.mockito.Mockito.*;

public class DireccionTest {

	@Test
	public void direccionPuedeCalcularSiguientePosicion() {
		Direccion dir = Direccion.SO; //Sur-Oeste
		Posicion pos = new Posicion(2,3);
		
		assertTrue(dir.calcularPosicionSiguiente(pos).equals(new Posicion(1,2)));
	}
	
	
}
