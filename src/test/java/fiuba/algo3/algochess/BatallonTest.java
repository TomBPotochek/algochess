package fiuba.algo3.algochess;

import static org.junit.Assert.assertEquals;

import fiuba.algo3.algochess.modelo.Direccion;
import org.junit.Test;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.juego.Posicion;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import fiuba.algo3.algochess.modelo.unidad.Curandero;
import fiuba.algo3.algochess.modelo.unidad.Soldado;

public class BatallonTest {

	@Test
	public void test01TresSoldadosContiguosSeMuevenEnBatallon() {
		
		Equipo unEquipo = new Equipo("A");
		Equipo otroEquipo = new Equipo("B");
		
		Posicion posicionInicial1 = new Posicion(2,3);
		Posicion posicionInicial2 = new Posicion(2,4);
		Posicion posicionInicial3 = new Posicion(2,5);
		
		Posicion posicionFinal1 = new Posicion(3,3);
		Posicion posicionFinal2 = new Posicion(3,4);
		Posicion posicionFinal3 = new Posicion(3,5);
		
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo);
		
		Soldado soldado1 = new Soldado(posicionInicial1, unEquipo);
		Soldado soldado2 = new Soldado(posicionInicial2, unEquipo);
		Soldado soldado3 = new Soldado(posicionInicial3, unEquipo);
		
		tablero.colocarUnidad(soldado1, posicionInicial1);
		tablero.colocarUnidad(soldado2, posicionInicial2);
		tablero.colocarUnidad(soldado3, posicionInicial3);
		
		soldado2.mover(Direccion.E, tablero);
		
		assertEquals(soldado2.obtenerPosicion(), posicionFinal2);
		assertEquals(soldado1.obtenerPosicion(), posicionFinal1);
		assertEquals(soldado3.obtenerPosicion(), posicionFinal3);
	}
	
	@Test
	public void test02DosSoldadosContiguosSeMuevenEnBatallonYUnTerceroObstaculizadoNo() {

		Equipo unEquipo = new Equipo("A");
		Equipo otroEquipo = new Equipo("B");
		
		Posicion posicionInicial1 = new Posicion(2,3);
		Posicion posicionInicial2 = new Posicion(2,4);
		Posicion posicionInicial3 = new Posicion(2,5);
		Posicion posicionInicialCurandero = new Posicion(3,4);

		Posicion posicionFinal1 = new Posicion(3,3);
		Posicion posicionFinal3 = new Posicion(3,5);
		
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo);
		
		Soldado soldado1 = new Soldado(posicionInicial1, unEquipo);
		Soldado soldado2 = new Soldado(posicionInicial2, unEquipo);
		Soldado soldado3 = new Soldado(posicionInicial3, unEquipo);
		
		Curandero curandero = new Curandero(posicionInicialCurandero, unEquipo);
		
		tablero.colocarUnidad(soldado1, posicionInicial1);
		tablero.colocarUnidad(soldado2, posicionInicial2);
		tablero.colocarUnidad(soldado3, posicionInicial3);
		tablero.colocarUnidad(curandero, posicionInicialCurandero);
		
		soldado2.mover(Direccion.E, tablero);
		
		// soldados 1 y 3 se mueven pero soldado 2 obstaculizado no
		assertEquals(soldado2.obtenerPosicion(), posicionInicial2);
		assertEquals(soldado1.obtenerPosicion(), posicionFinal1);
		assertEquals(soldado3.obtenerPosicion(), posicionFinal3);
	}
	
	@Test
	public void test03ElBatallonSeDisuelveCuandoUnSoldadoNoSePudoMover() {

		Equipo unEquipo = new Equipo("A");
		Equipo otroEquipo = new Equipo("B");
		
		Posicion posicionInicial1 = new Posicion(2,3);
		Posicion posicionInicial2 = new Posicion(2,4);
		Posicion posicionInicial3 = new Posicion(2,5);
		Posicion posicionInicialCurandero = new Posicion(3,4);

		Posicion posicionFinal1 = new Posicion(3,3);
		
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo);
		
		Soldado soldado1 = new Soldado(posicionInicial1, unEquipo);
		Soldado soldado2 = new Soldado(posicionInicial2, unEquipo);
		Soldado soldado3 = new Soldado(posicionInicial3, unEquipo);
		
		Curandero curandero = new Curandero(posicionInicialCurandero, unEquipo);
		
		tablero.colocarUnidad(soldado1, posicionInicial1);
		tablero.colocarUnidad(soldado2, posicionInicial2);
		tablero.colocarUnidad(soldado3, posicionInicial3);
		tablero.colocarUnidad(curandero, posicionInicialCurandero);
		
		// se disuelve el batallon porque el soldado 2 esta obstaculizado
		
		soldado2.mover(Direccion.E, tablero);
		soldado3.mover(Direccion.O, tablero);
		
		// Se mueve solo el soldado3 porque el batallon queda disuelto
		assertEquals(soldado3.obtenerPosicion(), posicionInicial3); // se mueve
		assertEquals(soldado2.obtenerPosicion(), posicionInicial2); // no se mueve
		assertEquals(soldado1.obtenerPosicion(), posicionFinal1); // no se mueve
	}
	
	@Test
	public void test04CuandoHay4SoldadosContiguosSolo3SeMuevenEnBatallon() {

		Equipo unEquipo = new Equipo("A");
		Equipo otroEquipo = new Equipo("B");
		
		Posicion posicionInicial1 = new Posicion(2,3);
		Posicion posicionInicial2 = new Posicion(2,4);
		Posicion posicionInicial3 = new Posicion(2,5);
		Posicion posicionInicial4 = new Posicion(2,6);

		Posicion posicionFinal1 = new Posicion(3,3);
		Posicion posicionFinal2 = new Posicion(3,4);
		Posicion posicionFinal3 = new Posicion(3,5);
		
		Tablero tablero = new Tablero(20, unEquipo, otroEquipo);
		
		Soldado soldado1 = new Soldado(posicionInicial1, unEquipo);
		Soldado soldado2 = new Soldado(posicionInicial2, unEquipo);
		Soldado soldado3 = new Soldado(posicionInicial3, unEquipo);
		Soldado soldado4 = new Soldado(posicionInicial4, unEquipo);
			
		tablero.colocarUnidad(soldado1, posicionInicial1);
		tablero.colocarUnidad(soldado2, posicionInicial2);
		tablero.colocarUnidad(soldado3, posicionInicial3);
		tablero.colocarUnidad(soldado4, posicionInicial4);
		
		soldado1.mover(Direccion.E, tablero);
		
		assertEquals(soldado1.obtenerPosicion(), posicionFinal1);
		assertEquals(soldado2.obtenerPosicion(), posicionFinal2);
		assertEquals(soldado3.obtenerPosicion(), posicionFinal3);
		assertEquals(soldado4.obtenerPosicion(), posicionInicial4);
	}
}
