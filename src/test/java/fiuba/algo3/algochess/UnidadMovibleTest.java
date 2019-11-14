package fiuba.algo3.algochess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fiuba.algo3.algochess.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;
import fiuba.algo3.algochess.unidad.Curandero;
import fiuba.algo3.algochess.unidad.Jinete;
import fiuba.algo3.algochess.unidad.Soldado;
import fiuba.algo3.algochess.unidad.UnidadMovible;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UnidadMovibleTest {
    
	@Test
    public void test01UnidadMoviblePuedeMoverseAUnCasilleroAdyecenteNoOcupado() {
		Posicion posInicialMock = mock(Posicion.class);
        Posicion posFinalMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);

		when(posInicialMock.esAdyacente(posFinalMock)).thenReturn(true);

        Curandero unidad = new Curandero(posInicialMock, unEquipoMock);

        unidad.mover(posFinalMock, tableroMock);
        assertTrue(posFinalMock.equals(unidad.obtenerPosicion()));
    }
    
    @Test
    public void test02UnidadMovibleNoPuedeMoverseAUnCasilleroOcupado() {
    	
    	Posicion posInicialMock = mock(Posicion.class);
        Posicion posFinalMock = mock(Posicion.class);    
    	Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
    	UnidadMovible jinete = new Jinete(posInicialMock, unEquipoMock);
    	
    	when(posInicialMock.esAdyacente(posFinalMock)).thenReturn(true);
    	doThrow(CasillaOcupadaException.class).when(tableroMock).moverUnidad(posInicialMock, posFinalMock);
   
    	assertThrows(CasillaOcupadaException.class, () -> {

    		jinete.mover(posFinalMock, tableroMock);
    	});
    }
    
    @Test
    public void test03UnidadMovibleNoPuedeMoverseAUnCasilleroNoAdyacente() {

    	Posicion posInicialMock = mock(Posicion.class);
        Posicion posFinalMock = mock(Posicion.class);    
    	Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
    	UnidadMovible soldado = new Soldado(posInicialMock, unEquipoMock);
    	
    	when(posInicialMock.esAdyacente(posFinalMock)).thenReturn(false);
   
    	assertThrows(MovimientoInvalidoException.class, () -> {
    	
    		soldado.mover(posFinalMock, tableroMock);
    	});	

    }
    
    // Test de integracion
    @Test
    public void test04UnidadMoviblePuedeMoverseEnTodasLasDirecciones() {
		Equipo Equipo1 = new Equipo("Equipo 1");
		Equipo Equipo2 = new Equipo("Equipo 2");

		Posicion posInicial = new Posicion(2,3);
	   	UnidadMovible soldado = new Soldado(posInicial, Equipo1);

        Posicion posFinal = new Posicion(3,3);
    	Tablero tablero = new Tablero(20, Equipo1, Equipo2);

    	tablero.colocarUnidad(soldado, posInicial);

    	soldado.mover(posFinal, tablero);

    	assertTrue(tablero.obtenerCasilla(posFinal).quitar().equals(soldado));
    }
}