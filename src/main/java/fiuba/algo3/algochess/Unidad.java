package fiuba.algo3.algochess;

import static java.lang.Math.min;

public abstract class Unidad {
    protected int vidaInicial;
    protected int vidaRestante;
    protected int costo;
    protected Posicion posicion;
    protected int danioAtaqueCuerpoACuerpo;
    protected int danioAtaqueADistancia;

    public Unidad(Posicion posicionInicial) {

    	this.posicion = posicionInicial;
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

    public int obtenerCosto() {
        return costo;
    }

	public void recibirVida(int vida) {

        this.vidaRestante = min(this.vidaRestante + vida, this.vidaInicial);
//		if (this.vidaRestante + vida < this.vidaInicial)
//			this.vidaRestante += vida;
//
//		else
//			this.vidaRestante = this.vidaInicial;
	}

	public boolean estaMuerto() {
        return vidaRestante <= 0;
    }
}

