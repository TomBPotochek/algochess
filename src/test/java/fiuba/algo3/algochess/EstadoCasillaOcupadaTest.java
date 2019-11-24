package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import fiuba.algo3.algochess.model.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.model.tablero.EstadoCasillaOcupada;
import fiuba.algo3.algochess.model.unidad.Unidad;

import org.junit.jupiter.api.Test;

class EstadoCasillaOcupadaTest {

	@Test
	void test01colocarUnidadEnCasillaOcupadaLanzaExcepcion() {
		Unidad unaUnidadMock = mock(Unidad.class);
		Unidad otraUnidadMock = mock(Unidad.class);
		EstadoCasillaOcupada estado = new EstadoCasillaOcupada(unaUnidadMock);
		assertThrows(CasillaOcupadaException.class, () -> {

			estado.colocarUnidad(otraUnidadMock);
		});
	}

}
