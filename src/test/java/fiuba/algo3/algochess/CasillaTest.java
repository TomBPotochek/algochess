package fiuba.algo3.algochess;

import fiuba.algo3.algochess.modelo.excepciones.CasillaEnemigaException;
import fiuba.algo3.algochess.modelo.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.tablero.Casilla;
import fiuba.algo3.algochess.modelo.tablero.EstadoCasillaLibre;
import fiuba.algo3.algochess.modelo.tablero.EstadoCasillaOcupada;
import fiuba.algo3.algochess.modelo.unidad.Unidad;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasillaTest {

	@Test
	public void test00CasillaEsCreadoSinNingunaUnidad(){

		Equipo unEquipoMock = mock(Equipo.class);
		Casilla casilla = new Casilla(unEquipoMock);

		assertEquals(casilla.getEstado().getClass(), EstadoCasillaLibre.class);

	}

	@Test
	public void test01CasillaEsOcupadaCuandoSeColocaUnaUnidad(){
		Unidad unaUnidadMock = mock(Unidad.class);
		Equipo unEquipoMock = mock(Equipo.class);
		when(unaUnidadMock.esAliada(unEquipoMock)).thenReturn(Boolean.TRUE);
		Casilla casilla = new Casilla(unEquipoMock);

		casilla.colocar(unaUnidadMock);

		assertEquals(casilla.getEstado().getClass(), EstadoCasillaOcupada.class);

	}

	@Test
	public void test02CasillaTiraErrorCuandoSeIntentaDeColocarUnaUnidadYEstaOcupada(){

		Unidad unaUnidadMock = mock(Unidad.class);
		Unidad otraUnidadMock = mock(Unidad.class);
		Equipo unEquipoMock = mock(Equipo.class);
		when(unaUnidadMock.esAliada(unEquipoMock)).thenReturn(Boolean.TRUE);
		when(otraUnidadMock.esAliada(unEquipoMock)).thenReturn(Boolean.TRUE);
		Casilla casilla = new Casilla(unEquipoMock);
		casilla.colocar(unaUnidadMock);


		assertThrows(CasillaOcupadaException.class, () -> {

			casilla.colocar(otraUnidadMock);
		});
	}

	@Test
	public void test03CasillaTiraErrorCuandoSeIntentaColocarEnUnaCasillaEnemiga(){

		Unidad unaUnidadMock = mock(Unidad.class);
		Equipo unEquipoMock = mock(Equipo.class);
		when(unaUnidadMock.esAliada(unEquipoMock)).thenReturn(Boolean.FALSE);
		Casilla casilla = new Casilla(unEquipoMock);

		assertThrows(CasillaEnemigaException.class, () -> {

			casilla.colocar(unaUnidadMock);
		});
	}
}
