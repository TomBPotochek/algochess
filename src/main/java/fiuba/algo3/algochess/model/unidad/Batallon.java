package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.CANTIDAD_SOLDADOS_BATALLON;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import fiuba.algo3.algochess.model.excepciones.BatallonIncompletoException;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public class Batallon {

	private List<Soldado> soldados;
	
	public Batallon() {

		this.soldados = new LinkedList<Soldado>();
	}
	
	public void agregar(Soldado unSoldado) {
		
		if (this.soldados.size() < CANTIDAD_SOLDADOS_BATALLON) {
			
			soldados.add(unSoldado);
		}
	}
	
	public void mover(Direccion direccion, Tablero tablero) throws MovimientoInvalidoException {

		if (this.soldados.size() < CANTIDAD_SOLDADOS_BATALLON)
			throw new BatallonIncompletoException();

		this.moverSoldados(direccion, tablero);
	}

	private void moverSoldados(Direccion direccion, Tablero tablero) {
		Iterator<Soldado> i = this.soldados.iterator();
		
		while (i.hasNext()) {
			
			try {
				Soldado unSoldado = i.next();
				unSoldado.moverIndividual(direccion, tablero);
				i.remove();
				this.moverSoldados(direccion, tablero);
				break;
				
			} catch (MovimientoInvalidoException ex) {}
		}

		if (this.soldados.size() == CANTIDAD_SOLDADOS_BATALLON)
			throw new MovimientoInvalidoException("Movimiento de batallon invalido");
		
	}
}
