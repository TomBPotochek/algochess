package fiuba.algo3.algochess.tablero;

import fiuba.algo3.algochess.distancia.Distancia;
import fiuba.algo3.algochess.juego.Arma;
import fiuba.algo3.algochess.juego.Espada;
import fiuba.algo3.algochess.unidad.Jinete;
import fiuba.algo3.algochess.unidad.Unidad;

abstract public class EstadoArma {
	/*
	protected Arma arma;
	
	public EstadoArma() {
		this.arma = new Espada();
	}
	
	public EstadoArma(Arma arma) {
		this.arma = arma;
	}*/
	
	abstract public void ponerAyF(Jinete jinete);
	
	abstract public void ponerEspada(Jinete jinete);
	

}
