package fiuba.algo3.algochess.tablero;

import fiuba.algo3.algochess.juego.ArcoYFlecha;
import fiuba.algo3.algochess.unidad.Jinete;

public class EstadoArmaEspada extends EstadoArma {

	public EstadoArmaEspada() {
	
	}
	

	@Override
	public void ponerAyF(Jinete jinete) {
		jinete.setEstado(new EstadoArmaAyF(), new ArcoYFlecha());

	}

	@Override
	public void ponerEspada(Jinete jinete) {
		

	}

}
