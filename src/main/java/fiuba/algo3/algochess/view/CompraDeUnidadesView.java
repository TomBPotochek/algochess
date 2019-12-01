package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class CompraDeUnidadesView implements AbstractView {

	private ContenedorTablero contenedorTablero;
	private ContenedorComprarUnidades contenedorComprarUnidades;
	private String tipoDeUnidadSeleccionada;
	
	public CompraDeUnidadesView(AlgoChess algochess) {

		this.contenedorTablero = new ContenedorTablero(algochess.obtenerTablero());
		this.contenedorComprarUnidades = new ContenedorComprarUnidades(algochess);
	}
	
	@Override
	public Scene dibujar() {

        BorderPane contenedorPrincipal = new BorderPane();
        Pane lateralBox = contenedorComprarUnidades.dibujar();
        Pane tableroBox = contenedorTablero.dibujar();
        lateralBox.setPrefWidth(400);
        lateralBox.setPadding(new Insets(20,20,20,20));
        tableroBox.setPadding(new Insets(20,20,20,20));
        contenedorPrincipal.setLeft(lateralBox);
        contenedorPrincipal.setCenter(tableroBox);
//       contenedorPrincipal.setPrefSize(stage.getWidth(), stage.getHeight());
//        stage.setScene(new Scene(contenedorPrincipal));
		return new Scene(contenedorPrincipal);
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
		// TODO Auto-generated method stub
		
	}

	public void mostrarError(String error) {
		this.contenedorComprarUnidades.mostrarError(error);
		
	}
}
