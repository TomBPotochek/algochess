package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import java.util.HashMap;

public class CompraDeUnidadesView implements AbstractView {

	private ContenedorTablero contenedorTablero;
	private ContenedorComprarUnidades contenedorComprarUnidades;
	private String tipoDeUnidadSeleccionada;
	
	public CompraDeUnidadesView(AlgoChess algochess, HashMap<String,String> colores) {

		this.contenedorTablero = new ContenedorTablero(algochess.obtenerTablero(), algochess.getTurnoActual(), colores);
		this.contenedorComprarUnidades = new ContenedorComprarUnidades(algochess.getTurnoActual(), colores);
	}
	
	@Override
	public Scene dibujar() {

        BorderPane contenedorPrincipal = new BorderPane();
        Pane lateralBox = contenedorComprarUnidades.dibujar();
        Pane tableroBox = contenedorTablero.dibujar();
        lateralBox.setPadding(new Insets(20,20,20,20));
        tableroBox.setPadding(new Insets(20,20,20,20));
        contenedorPrincipal.setLeft(lateralBox);
        contenedorPrincipal.setCenter(tableroBox);

        return new Scene(contenedorPrincipal, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
	}

	public String getTipoDeUnidadSeleccionada() {
		return tipoDeUnidadSeleccionada;
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

	public void pintarTablero() {
		this.contenedorTablero.actualizar();
		
	}

	public void onCasillaClick(EventHandler<ActionEvent> e) {

		this.contenedorTablero.onCasillaClick(e);
	}

	public void mostrarError(String error) {
		this.contenedorComprarUnidades.mostrarError(error);
		
	}
}
