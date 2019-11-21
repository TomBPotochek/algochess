package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Arma;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.tablero.Tablero;
import fiuba.algo3.algochess.Direccion;
import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.excepciones.UnidadDestruidaException;

public abstract class Unidad {
    protected int vidaInicial;
    protected int vidaRestante;
    protected int costo;
    protected Posicion posicion;
    protected int danioAtaqueCuerpoACuerpo;
    protected int danioAtaqueADistancia;
    protected Equipo equipo;
	protected Arma arma;

    public Unidad(Posicion posicionInicial, Equipo equipo) {

    	this.posicion = posicionInicial;
    	this.equipo = equipo;
	}

	//este idealmente no deberia usarse. Seria mejor sacarlo
    public Posicion obtenerPosicion() {
        return posicion;
    }
    
    public void recibirDanio(int danio) throws UnidadDestruidaException {
    	
    	this.vidaRestante -= danio;
    	
    	if (this.vidaRestante <= 0) {
    		throw new UnidadDestruidaException();
    	}
    }
    
    public int getVidaRestante() {

    	return vidaRestante;
    }

    public boolean esAliada(Equipo otroEquipo) {
    	return (this.equipo == otroEquipo);
	}

    public int obtenerCosto() {
        return costo;
    }

    
	public void recibirVida(int vida) {
		
		this.vidaRestante += vida;
		
		if (this.vidaRestante > this.vidaInicial)
			this.vidaRestante = this.vidaInicial;
	}
    

	public boolean estaMuerto() {
        return vidaRestante <= 0;
    }
	

	public void atacar(Unidad unidad, Tablero tablero) {
		Distancia distancia = this.obtenerPosicion().calcularDistancia(unidad.obtenerPosicion());
		try {
			distancia.atacar(unidad, this.arma);		
		} catch (UnidadDestruidaException e) {
			tablero.quitarUnidad(unidad);
			throw e;
		}
	}

	protected void cambiarEstadoDeUnidad(Jinete jinete) {
			if (!jinete.esAliada(this.equipo))
				jinete.ponerEspada();
	}
	
	public void reclutar(Soldado unSoldado, Direccion direccionReclutamiento, Tablero tablero) {}

}

