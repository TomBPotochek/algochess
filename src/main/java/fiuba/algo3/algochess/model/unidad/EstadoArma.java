package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.distancia.Distancia;

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
