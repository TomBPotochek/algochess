package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.model.excepciones.BatallonIncompletoException;
import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.*;


public class Soldado extends UnidadMovible {


	private Batallon batallon;

	public Soldado(Posicion unaPosicion, Equipo equipo) {
		
		super(unaPosicion, equipo);
		
		this.vidaInicial = VIDA_SOLDADO;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_SOLDADO;
	//	this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_SOLDADO;
	//	this.danioAtaqueADistancia = DANIO_DISTANCIA_SOLDADO;
		this.arma = new EspadaLarga();

	}

	
	@Override
	protected void cambiarEstadoDeUnidad(Jinete unJinete) {
		if (unJinete.esAliada(this.equipo))
			unJinete.ponerAyF();
		else
			unJinete.ponerEspada();
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
