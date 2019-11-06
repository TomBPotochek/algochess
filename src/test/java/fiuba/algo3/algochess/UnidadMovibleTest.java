package fiuba.algo3.algochess;

import static org.junit.Assert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class UnidadMovibleTest {
    
	@Test
    public void test01UnidadMoviblePuedeMoverseAUnCasilleroAdyecenteNoOcupado() {
		Posicion posInicialMock = mock(Posicion.class);
        Posicion posFinalMock = mock(Posicion.class);
		Tablero tableroMock = mock(Tablero.class);

		when(posInicialMock.esAdyacente(posFinalMock)).thenReturn(true);

        Curandero unidad = new Curandero(posInicialMock);

        unidad.mover(posFinalMock, tableroMock);
        assertTrue(posFinalMock.equals(unidad.getPosicion()));
    }
    
    @Test
    public void test02UnidadMovibleNoPuedeMoverseAUnCasilleroOcupado() {
    	
    	Posicion posInicialMock = mock(Posicion.class);
        Posicion posFinalMock = mock(Posicion.class);    
    	Tablero tableroMock = mock(Tablero.class);
    	UnidadMovible jinete = new Jinete(posInicialMock);
    	
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
    	UnidadMovible soldado = new Soldado(posInicialMock);
    	
    	when(posInicialMock.esAdyacente(posFinalMock)).thenReturn(false);
   
    	assertThrows(MovimientoInvalidoException.class, () -> {
    	
    		soldado.mover(posFinalMock, tableroMock);
    	});	

    }
}