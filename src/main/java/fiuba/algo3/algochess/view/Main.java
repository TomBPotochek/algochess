package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.lang.reflect.*;

public class Main extends Application {

	public AlgoChess algoChess;
	private Stage stage;
    public ContenedorTablero contenedorTablero;
    public ContenedorComprarUnidades contenedorComprarUnidades;

	public static void main(String[] args) {

		launch(args);
	}

	public Scene dibujarEscenaArmadoJuego() throws Exception {
		Field field = AlgoChess.class.getDeclaredField("tablero");
		field.setAccessible(true);
		Tablero tablero = (Tablero) field.get(algoChess);

		FlowPane contenedorPrincipal = new FlowPane(Orientation.HORIZONTAL);
		contenedorComprarUnidades = new ContenedorComprarUnidades(algoChess);
		contenedorTablero = new ContenedorTablero(this, tablero);

		contenedorPrincipal.getChildren().addAll(contenedorComprarUnidades.construir(), contenedorTablero.construir());

		return new Scene(contenedorPrincipal, 640, 480);
	}

	public Scene dibujarEscenaSeleccionDeEquipos() {
		FlowPane contenedorSeleccionEquipos = new FlowPane(Orientation.VERTICAL);
		TextField inputEquipo1 = new TextField("Nombre jugador 1");
		TextField inputEquipo2 = new TextField("Nombre jugador 2");
		
		Font inputFont = Font.font(35);
		inputEquipo1.setFont(inputFont);
		inputEquipo2.setFont(inputFont);
		
		inputEquipo1.setPrefSize(400, 80);
		inputEquipo2.setPrefSize(400, 80);
		
		Button btnEquiposSeleccionados = new Button("Listo!");
		btnEquiposSeleccionados.setPrefSize(200, 50);
		btnEquiposSeleccionados.setFont(Font.font(20));
		HBox input1Box = new HBox(inputEquipo1);
		HBox input2Box = new HBox(inputEquipo2);
		Insets paddingTextos = new Insets(10,0,10,0); 
		input1Box.setPadding(paddingTextos);
		input2Box.setPadding(paddingTextos);

		contenedorSeleccionEquipos.setAlignment(Pos.CENTER);
		contenedorSeleccionEquipos.getChildren().addAll(input1Box, input2Box, btnEquiposSeleccionados);

		btnEquiposSeleccionados.setOnAction(e -> {
			algoChess = new AlgoChess(inputEquipo1.getText(), inputEquipo2.getText());
			Scene escenaArmadoDeJuego = null;
			try {
				escenaArmadoDeJuego = dibujarEscenaArmadoJuego();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			stage.setScene(escenaArmadoDeJuego);
			stage.setMaximized(true);
		});
		return new Scene(contenedorSeleccionEquipos, 640, 480);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		stage.setTitle("AlgoChess");
		Scene escenaSeleccionDeEquipos = dibujarEscenaSeleccionDeEquipos();

        stage.setScene(escenaSeleccionDeEquipos);
        stage.setMaximized(true);
        stage.show();
	}


    public void actualizar() {
	    contenedorComprarUnidades.actualizar(algoChess);
	    contenedorTablero.actualizar();
    }
}
