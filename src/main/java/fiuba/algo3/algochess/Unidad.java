package fiuba.algo3.algochess;

public class Unidad {
    protected int vidaInicial;
    protected int vidaRestante;
    protected int costo;
    protected Posicion posicion;
    protected int danioAtaqueCuerpoACuerpo;
    protected int danioAtaqueADistancia;
    protected String equipo;

    public Unidad(Posicion posicionInicial, String equipo) {

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
    
    public boolean esAliada(String otroEquipo) {
    	return (this.equipo == otroEquipo);
    }
}

