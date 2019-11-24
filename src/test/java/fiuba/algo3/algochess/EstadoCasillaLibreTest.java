package fiuba.algo3.algochess;

import static org.junit.jupiter.api.Assertions.*;

import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.tablero.EstadoCasillaLibre;

import org.junit.jupiter.api.Test;

class EstadoCasillaLibreTest {

	@Test
	void test01quitarUnidadEnCasillaLibreNoLanzaExcepcion() {
		EstadoCasillaLibre estado = new EstadoCasillaLibre();
		assertThrows(CasillaLibreException.class, () -> {

			estado.quitarUnidad();
		});
	}
}
