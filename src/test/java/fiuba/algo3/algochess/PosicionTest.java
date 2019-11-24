package fiuba.algo3.algochess;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fiuba.algo3.algochess.model.tablero.Posicion;

class PosicionTest {

	@Test
	void testDosPosicionesDistintasConMismosValoresSonIguales() {
		Posicion unaPosicion = new Posicion(8, 4);
		Posicion otraPosicion = new Posicion(8,4);
		
		assertTrue(unaPosicion.equals(otraPosicion));
	}
	
	@Test
	void testDosPosicionesQueDifierenEnUnaUnidadEnUnaCoordenadaSonAdyacentes() {
		Posicion unaPosicion = new Posicion(8, 4);
		Posicion otraPosicion = new Posicion(8,3);
		
		assertTrue(unaPosicion.esAdyacente(otraPosicion));
	}
	
	@Test
	void test2PosicionesDistintasConMismosValoresProducenMismoHash() {
		Posicion unaPosicion = new Posicion(8, 4);
		Posicion otraPosicion = new Posicion(8,4);
		
		assertTrue(unaPosicion.hashCode() == otraPosicion.hashCode());
	}

}
