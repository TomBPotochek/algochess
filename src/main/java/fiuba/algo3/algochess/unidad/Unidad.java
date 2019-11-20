package fiuba.algo3.algochess.unidad;

import fiuba.algo3.algochess.juego.Equipo;
import fiuba.algo3.algochess.juego.Posicion;
import fiuba.algo3.algochess.excepciones.UnidadDestruidaException;

import static java.lang.Math.min;

public abstract class Unidad {
    protected int vidaInicial;
    protected int vidaRestante;
    protected int costo;
    protected Posicion posicion;
    protected int danioAtaqueCuerpoACuerpo;
    protected int danioAtaqueADistancia;
    protected Equipo equipo;

    public Unidad(Posicion posicionInicial, Equipo equipo) {

    	this.posicion = posicionInicial;
    	this.equipo = equipo;
	}

	//este idealmente no deberia usarse. Seria mejor sacarlo
    public Posicion obtenerPosicion() {
        return posicion;
    }
    
    public void recibirDanio(int danio) {
    	
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
}

