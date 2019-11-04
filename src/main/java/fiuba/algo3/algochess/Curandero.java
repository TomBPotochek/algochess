package fiuba.algo3.algochess;

public class Curandero extends UnidadMovible {
    private int curacion;

    public Curandero() {
        curacion = 15;
        vidaInicial = 75;
        vidaRestante = vidaInicial;
    }

//    public void curar(Unidad herido) {
//        herido.curarse(curacion);
//    }

}
