package fiuba.algo3.algochess.model.unidad;

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
