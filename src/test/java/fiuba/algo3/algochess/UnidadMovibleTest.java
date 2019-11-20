package fiuba.algo3.algochess;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fiuba.algo3.algochess.excepciones.CasillaOcupadaException;
import fiuba.algo3.algochess.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import static fiuba.algo3.algochess.juego.ProveedorConstantes.TAMANIO_TABLERO;
import fiuba.algo3.algochess.tablero.Tablero;
import fiuba.algo3.algochess.unidad.Curandero;
import fiuba.algo3.algochess.unidad.Jinete;
import fiuba.algo3.algochess.unidad.Soldado;
import fiuba.algo3.algochess.unidad.UnidadMovible;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class UnidadMovibleTest {
    
	@Test //no se si tiene sentido hacer esta Unitaria
    public void test01UnidadMoviblePuedeMoverseAUnCasilleroLibre() {
		Direccion direccion = Direccion.N;
        Posicion posicion = mock(Posicion.class);
        
        when(posicion.obtenerCoordenadaX()).thenReturn(2);
        when(posicion.obtenerCoordenadaY()).thenReturn(1);
        
       // Posicion posAdyacente = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);

		
		

        Curandero unidad = new Curandero(posicion, unEquipoMock);

        unidad.mover(direccion, tableroMock);
        //assertTrue(posAdyacente.equals(unidad.obtenerPosicion()));
        assertTrue(unidad.obtenerPosicion().equals(new Posicion(2,2))); 
    }
    
    @Test
    public void test02UnidadMovibleNoPuedeMoverseAUnCasilleroOcupado() {
    	
		Direccion direccion = Direccion.E;
        Posicion posicion = new Posicion(1,1);
        Posicion posAdyacente = new Posicion(2,1);   
    	Tablero tableroMock = mock(Tablero.class);
		Equipo unEquipoMock = mock(Equipo.class);
    	UnidadMovible jinete = new Jinete(posicion, unEquipoMock);
    	
    //	when(direccion.calcularPosicionSiguiente(posicion)).thenReturn(posAdyacente);
    	doThrow(CasillaOcupadaException.class).when(tableroMock).moverUnidad(posicion, posAdyacente);
   
    	assertThrows(MovimientoInvalidoException.class, () -> {

    		jinete.mover(direccion, tableroMock);
    	});
    	
    	assertTrue(jinete.obtenerPosicion().equals(posicion));
    }
    /*
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
    */
    
    // Test de integracion
    @Test
    public void test04UnidadMoviblePuedeMoverseEnTodasLasDirecciones() {
		Equipo Equipo1 = new Equipo("Equipo 1");
		Equipo Equipo2 = new Equipo("Equipo 2");

		Posicion posicion = new Posicion(2,3);
		Posicion posFinal = new Posicion(2,4);
	   	UnidadMovible soldado = new Soldado(posicion, Equipo1);

        Direccion dir = Direccion.N;
    	Tablero tablero = new Tablero(TAMANIO_TABLERO, Equipo1, Equipo2);

    	tablero.colocarUnidad(soldado, posicion);

    	soldado.mover(dir, tablero);

    	assertTrue(tablero.obtenerCasilla(posFinal).quitar().equals(soldado));
    }
}