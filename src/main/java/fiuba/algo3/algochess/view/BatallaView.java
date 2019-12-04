package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

public class BatallaView implements AbstractView {

	private ContenedorTablero contenedorTablero;
	private ContenedorControlesJuego contenedorControlesJuego;

	public BatallaView(AlgoChess algoChess) {
		this.contenedorTablero = new ContenedorTablero(algoChess.obtenerTablero(), algoChess.getTurnoActual());
		this.contenedorControlesJuego = new ContenedorControlesJuego(algoChess.getTurnoActual());
	}

	@Override
	public Scene dibujar() {
		BorderPane contenedorPrincipal = new BorderPane();
		Pane lateralBox = contenedorControlesJuego.dibujar();
		Pane tableroBox = contenedorTablero.dibujar();
		lateralBox.setPadding(new Insets(20,20,20,20));
		tableroBox.setPadding(new Insets(20,20,20,20));
		contenedorPrincipal.setLeft(lateralBox);
		contenedorPrincipal.setCenter(tableroBox);
		return new Scene(contenedorPrincipal);
	}

	public void onCasillaClick(EventHandler<ActionEvent> e) {
		this.contenedorTablero.onCasillaClick(e);
	}

	public void onAtacarClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onAtacarClick(e);
	}

	public void onMoverNorteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverNorteClick(e);
	}
	public void onMoverNorEsteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverNorEsteClick(e);
	}
	public void onMoverEsteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverEsteClick(e);
	}
	public void onMoverSurEsteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverSurEsteClick(e);
	}
	public void onMoverSurClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverSurClick(e);
	}
	public void onMoverSurOesteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverSurOesteClick(e);
	}
	public void onMoverOesteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverOesteClick(e);
	}
	public void onMoverNorOesteClick(EventHandler<ActionEvent> e) {
		this.contenedorControlesJuego.onMoverNorOesteClick(e);
	}

	public void mostrarError(String error) {
		this.contenedorControlesJuego.mostrarError(error);
	}

	public void pintarTablero() {
		this.contenedorTablero.actualizar();
	}

}
