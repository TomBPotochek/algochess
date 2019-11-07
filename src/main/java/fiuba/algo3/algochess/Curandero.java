package fiuba.algo3.algochess;

public class Curandero extends UnidadMovible {
    private int curacion;

    public Curandero(Posicion unaPosicion, String equipo) {
    	super(unaPosicion, equipo);

    	this.curacion = 15;
    	this.vidaInicial = 75;
    	this.vidaRestante = vidaInicial;
    	this.costo = 2;
    }

    //y si no es movible?
	public void curar(UnidadMovible unidadAliada) {
		
		unidadAliada.recibirVida(this.curacion);
		
	}

}
