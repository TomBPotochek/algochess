package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

import fiuba.algo3.algochess.Direccion;

public class Soldado extends AtacanteMovible {

	private Batallon batallon;

	public Soldado(Posicion unaPosicion, Equipo equipo) {
		
		super(unaPosicion, equipo);
		
		this.vidaInicial = VIDA_SOLDADO;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_SOLDADO;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_SOLDADO;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_SOLDADO;

	}

	@Override
	public void atacarADistanciaCorta(Unidad unaUnidad) {
		// chequear condiciones
		unaUnidad.recibirDanio(danioAtaqueCuerpoACuerpo);
	}
	@Override
	public void atacarADistanciaMedia(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	@Override
	public void atacarADistanciaLarga(Unidad unaUnidad) {
		throw new AtaqueInvalidoException();
	}
	
	@Override
	public void reclutar(Soldado reclutador, Direccion direccionReclutamiento, Tablero tablero) {
		
		reclutador.agregarAlBatallon(this);
	
		try {
			
			Unidad unidadContigua = tablero.obtenerUnidad(direccionReclutamiento.calcularPosicionSiguiente(this.posicion));
			unidadContigua.reclutar(reclutador, direccionReclutamiento, tablero);
		
		} catch (CasillaLibreException ex) {}
	}

	private void agregarAlBatallon(Soldado soldado) {
		
		this.batallon.agregar(soldado);
	}
	
	@Override
	public void mover(Direccion direccionMovimiento, Tablero tablero) {
		

		for (Direccion unaDireccion : Direccion.values()) {

			this.batallon = new Batallon();
			
				
				this.batallon.agregar(this);

				try {
					Unidad unaUnidadContigua = tablero.obtenerUnidad(unaDireccion.calcularPosicionSiguiente(this.posicion));
					unaUnidadContigua.reclutar(this, unaDireccion, tablero);

				} catch (CasillaLibreException ex) {}
				
				Direccion direccionOpuesta = unaDireccion.direccionOpuesta();

				try {
					Unidad otraUnidadContigua = tablero.obtenerUnidad(direccionOpuesta.calcularPosicionSiguiente(this.posicion));
					otraUnidadContigua.reclutar(this, direccionOpuesta, tablero);
				
				} catch (CasillaLibreException ex) {}

				try {
					this.batallon.mover(direccionMovimiento, tablero);
				} catch (BatallonIncompletoException ex) {
					continue;
				}

				return; // si llega aca es porque el batallon se pudo mover y debe salir del metodo
		}
		
		this.moverIndividual(direccionMovimiento, tablero);
	}

	public void moverIndividual(Direccion direccionMovimiento, Tablero tablero) {
		
		super.mover(direccionMovimiento, tablero);
	}
}
