package fiuba.algo3.algochess.modelo.tablero;

import fiuba.algo3.algochess.modelo.unidad.Jinete;

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
