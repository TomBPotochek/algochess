package fiuba.algo3.algochess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class UnidadMovibleTest {
    
	@Test
    public void test01UnidadMoviblePuedeMoverseEnTodasLasDirecciones() {
        Posicion posFinal = new Posicion(3,3);
		
		Tablero tableroMock = mock(Tablero.class);

        Curandero unidad = new Curandero(new Posicion(2,3));

        unidad.mover(new Posicion(3,3), tableroMock);
        assertTrue(posFinal.equals(unidad.getPosicion()));
    }
    
	/*
	 * @Test public void test02UnidadMovibleNoPuedeMoverseAUnCasilleroOcupado() {
	 * 
	 * Tablero tablero = new Tablero();
	 * 
	 * 
	 * UnidadMovible curandero = new Curandero(new Posicion(4,6)); UnidadMovible
	 * jinete = new Jinete(new Posicion(4,5));
	 * 
	 * 
	 * assertThrows(CasillaOcupadaException.class, () -> {
	 * 
	 * curandero.mover(new Posicion(4,5), tablero);
	 * 
	 * }); }
	 */
}