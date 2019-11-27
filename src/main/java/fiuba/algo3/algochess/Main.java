package fiuba.algo3.algochess;

import fiuba.algo3.algochess.controller.CasilleroEventHandler;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.view.ContenedorTablero;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.lang.reflect.*;

public class Main extends Application {

	AlgoChess algoChess;
	private Stage stage;

	public static void main(String[] args) {

		launch(args);
	}


	public VBox dibujarControles() {
		VBox contenedorControles = new VBox();
		Text turnoJugador = new Text("Turno de jugador #");
		Text puntosJ1 = new Text("Puntos restantes de Jugador1");
		Text puntosJ2 = new Text("Puntos restantes de Jugador2");
		Button btnJinete = new Button("Comprar Jinete");
		Button btnSoldado = new Button("Comprar Soldado");
		Button btnCatapulta = new Button("Comprar Catapulta");
		Button btnCurandero = new Button("Comprar Curandero");
		btnJinete.setMaxWidth(Double.MAX_VALUE);
		btnSoldado.setMaxWidth(Double.MAX_VALUE);
		btnCatapulta.setMaxWidth(Double.MAX_VALUE);
		btnCurandero.setMaxWidth(Double.MAX_VALUE);

		contenedorControles.setPadding(new Insets(5,5,5,5));
		contenedorControles.setSpacing(10);
		contenedorControles.getChildren().addAll(turnoJugador, btnJinete, btnSoldado, btnCatapulta, btnCurandero, puntosJ1, puntosJ2);

		return contenedorControles;
	}

	public Scene dibujarEscenaArmadoJuego() throws Exception {
		Field field = AlgoChess.class.getDeclaredField("tablero");
		field.setAccessible(true);
		Tablero tablero = (Tablero) field.get(algoChess);

		FlowPane contenedorPrincipal = new FlowPane(Orientation.HORIZONTAL);
		VBox contenedorControles = dibujarControles();
		GridPane contenedorTablero = (new ContenedorTablero(tablero)).construir();
		contenedorTablero.setMaxHeight(640);

		contenedorPrincipal.getChildren().addAll(contenedorControles, contenedorTablero);

		return new Scene(contenedorPrincipal, 640, 480);
	}

	public Scene dibujarEscenaSeleccionDeEquipos() {
		FlowPane contenedorSeleccionEquipos = new FlowPane(Orientation.VERTICAL);
		TextField inputEquipo1 = new TextField("Nombre del primer equipo");
		TextField inputEquipo2 = new TextField("Nombre del segundo equipo");
		Button btnEquiposSeleccionados = new Button("Listo!");
		contenedorSeleccionEquipos.getChildren().addAll(inputEquipo1, inputEquipo2, btnEquiposSeleccionados);

		btnEquiposSeleccionados.setOnAction(e -> {
			algoChess = new AlgoChess(inputEquipo1.getText(), inputEquipo2.getText());
			Scene escenaArmadoDeJuego = null;
			try {
				escenaArmadoDeJuego = dibujarEscenaArmadoJuego();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stage.setScene(escenaArmadoDeJuego);
		});
		return new Scene(contenedorSeleccionEquipos, 640, 480);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		stage.setTitle("AlgoChess");
		Scene escenaSeleccionDeEquipos = dibujarEscenaSeleccionDeEquipos();

		stage.setScene(escenaSeleccionDeEquipos);
        stage.show();
	}

	
}
