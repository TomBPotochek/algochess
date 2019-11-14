package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
