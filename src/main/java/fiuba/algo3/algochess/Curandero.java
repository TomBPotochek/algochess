package fiuba.algo3.algochess;

public class Curandero extends UnidadMovible {
    private int curacion;
    private int vidaInicial;
    private int vidaRestante;

    public Curandero(Posicion unaPosicion, String equipo) {
    	super(unaPosicion, equipo);

    	this.curacion = 15;
    	this.vidaInicial = 75;
    	this.vidaRestante = vidaInicial;
    	this.costo = 2;
    }


//    public void curar(Unidad herido) {
//        herido.curarse(curacion);
//    }

}
