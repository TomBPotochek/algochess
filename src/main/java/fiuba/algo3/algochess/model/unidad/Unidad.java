package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public abstract class Unidad {
    protected float vidaInicial;
    protected float vidaRestante;
    protected int costo;
    protected Posicion posicion;
   // protected int danioAtaqueCuerpoACuerpo;
   // protected int danioAtaqueADistancia;
    protected Equipo equipo;
	protected Arma arma;
	protected estaQuemado quemado;

    public Unidad(Posicion posicionInicial, Equipo equipo) {

    	this.posicion = posicionInicial;
    	this.equipo = equipo;
    	this.quemado = new NoQuemado();
	}

    public Posicion obtenerPosicion() {
        return posicion;
    }
    
    public void recibirDanio(float danio) throws UnidadDestruidaException {
    	
    	this.vidaRestante -= danio;
    	
    	if (this.vidaRestante <= 0) {
    		throw new UnidadDestruidaException();
    	}
    }
    
    public float getVidaRestante() {

    	return vidaRestante;
    }

    public boolean esAliada(Equipo otroEquipo) {
    	return (this.equipo == otroEquipo);
	}

    public int obtenerCosto() {
        return costo;
    }

    
	public abstract void recibirVida(float vida);
    

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

	public void quemar(Tablero tablero){
    	quemado.quemar(this, tablero);
    	this.quemado = new NoQuemado();
	}

	public void cambiarEstadoQuemado(){
    	quemado = new Quemado();
	}
}


