package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;

public class CompraDeUnidadesView implements AbstractView {

	private ContenedorTablero contenedorTablero;
	private ContenedorComprarUnidades contenedorComprarUnidades;
	
	public CompraDeUnidadesView(AlgoChess algochess) {

		this.contenedorTablero = new ContenedorTablero(algochess.obtenerTablero());
		this.contenedorComprarUnidades = new ContenedorComprarUnidades(algochess);
	}
	
	@Override
	public Scene dibujar() {
		// TODO Auto-generated method stub
		return null;
	}

    public void onComprarJineteClick(EventHandler<ActionEvent> e) {
    	
    	this.contenedorComprarUnidades.onComprarJineteClick(e);
    }
    
    public void onComprarSoldadoClick(EventHandler<ActionEvent> e) {
    	
    	this.contenedorComprarUnidades.onComprarSoldadoClick(e);
    }

    public void onComprarCatapultaClick(EventHandler<ActionEvent> e) {
    	
    	this.contenedorComprarUnidades.onComprarCatapultaClick(e);
    }

    public void onComprarCuranderoClick(EventHandler<ActionEvent> e) {
    	
    	this.contenedorComprarUnidades.onComprarCuranderoClick(e);
    }
    
    public void onComenzarBatallaClick(EventHandler<ActionEvent> e) {
    	
    	this.contenedorComprarUnidades.onComenzarBatallaClick(e);
    }

}
