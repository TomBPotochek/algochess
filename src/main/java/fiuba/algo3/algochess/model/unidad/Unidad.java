package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.distancia.Distancia;
import fiuba.algo3.algochess.model.excepciones.MovimientoInvalidoException;
import fiuba.algo3.algochess.model.excepciones.UnidadDestruidaException;
import fiuba.algo3.algochess.model.excepciones.UnidadQuemadaException;
import fiuba.algo3.algochess.model.juego.Equipo;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;

public abstract class Unidad {
    protected int vidaInicial;
    protected int vidaRestante;
    protected int costo;
    protected Posicion posicion;
    protected int danioAtaqueCuerpoACuerpo;
    protected int danioAtaqueADistancia;
    protected Equipo equipo;
	protected Arma arma;
	protected estaQuemado quemado;

    public Unidad(Posicion posicionInicial, Equipo equipo) {

    	this.posicion = posicionInicial;
    	this.equipo = equipo;
    	this.quemado = new NoQuemado();
	}

	public abstract void mover(Direccion direccion, Tablero tablero) throws MovimientoInvalidoException;

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

	public void quemar(Tablero tablero, Catapulta catapulta) {
		quemado.quemar(this, tablero, catapulta);
		catapulta.agregarAMatafuego(this);
	}

	public void cambiarEstadoQuemado(){
    	quemado = new Quemado();
	}

	public void cambiarEstadoNoQuemado(){
		quemado = new NoQuemado();
	}
}


