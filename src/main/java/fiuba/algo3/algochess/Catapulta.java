package fiuba.algo3.algochess;

public class Catapulta extends Unidad {
    public Catapulta(Posicion unaPosicion) {

    	super(unaPosicion);
  
    	this.vidaInicial = 50;
        this.vidaRestante = vidaInicial;
        this.costo = 5;
		this.posicion = unaPosicion;
		this.danioAtaqueADistancia = 20;
		this.danioAtaqueCuerpoACuerpo = 0;
   }
    
    
    public void atacarADistancia(Unidad otraUnidad) {
    	otraUnidad.recibirDanio(this.danioAtaqueADistancia);
    }
}