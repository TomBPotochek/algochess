package fiuba.algo3.algochess;

public class Curandero extends UnidadMovible {
    private int curacion;

    public Curandero(Posicion unaPosicion) {
    	this.curacion = 15;
    	this.vidaInicial = 75;
    	this.vidaRestante = vidaInicial;
    	this.costo = 2;
		this.posicion = unaPosicion;
    }

//    public void curar(Unidad herido) {
//        herido.curarse(curacion);
//    }

}
