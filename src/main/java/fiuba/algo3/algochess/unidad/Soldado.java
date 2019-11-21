package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.EspadaLarga;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;

import static fiuba.algo3.algochess.juego.ProveedorConstantes.*;

public class Soldado extends UnidadMovible {

	public Soldado(Posicion unaPosicion, Equipo equipo) {
		
		super(unaPosicion, equipo);
		
		this.vidaInicial = VIDA_SOLDADO;
		this.vidaRestante = vidaInicial;
		this.costo = COSTO_SOLDADO;
		this.danioAtaqueCuerpoACuerpo = DANIO_ARMA_SOLDADO;
		this.danioAtaqueADistancia = DANIO_DISTANCIA_SOLDADO;
		this.arma = new EspadaLarga();

	}

	
	@Override
	protected void cambiarEstadoDeUnidad(Jinete unJinete) {
		if (unJinete.esAliada(this.equipo))
			unJinete.ponerAyF();
		else
			unJinete.ponerEspada();
	}



}
