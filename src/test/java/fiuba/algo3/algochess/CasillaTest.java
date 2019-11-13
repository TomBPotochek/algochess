package fiuba.algo3.algochess;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CasillaTest {

	@Test
	public void test00CasillaEsCreadoSinNingunaUnidad(){

		Casilla casilla = new Casilla("Un equipo");

		assertEquals(casilla.getEstado().getClass(), EstadoCasillaLibre.class);

	}

	@Test
	public void test01CasillaEsOcupadaCuandoSeColocaUnaUnidad(){
		Unidad unaUnidadMock = mock(Unidad.class);
		when(unaUnidadMock.esAliada("unEquipo")).thenReturn(Boolean.TRUE);
		Casilla casilla = new Casilla("unEquipo");

		casilla.colocar(unaUnidadMock);

		assertEquals(casilla.getEstado().getClass(),EstadoCasillaOcupada.class);

	}

	@Test
	public void test02CasillaTiraErrorCuandoSeIntentaDeColocarUnaUnidadYEstaOcupada(){

		Unidad unaUnidadMock = mock(Unidad.class);
		Unidad otraUnidadMock = mock(Unidad.class);
		when(unaUnidadMock.esAliada("unEquipo")).thenReturn(Boolean.TRUE);
		when(otraUnidadMock.esAliada("unEquipo")).thenReturn(Boolean.TRUE);
		Casilla casilla = new Casilla("unEquipo");
		casilla.colocar(unaUnidadMock);


		assertThrows(CasillaOcupadaException.class, () -> {

			casilla.colocar(otraUnidadMock);
		});
	}

	@Test
	public void test03CasillaTiraErrorCuandoSeIntentaColocarEnUnaCasillaEnemiga(){

		Unidad unaUnidadMock = mock(Unidad.class);
		when(unaUnidadMock.esAliada("unEquipo")).thenReturn(Boolean.FALSE);
		Casilla casilla = new Casilla("unEquipo");

		assertThrows(CasillaEnemigaException.class, () -> {

			casilla.colocar(unaUnidadMock);
		});
	}
}
