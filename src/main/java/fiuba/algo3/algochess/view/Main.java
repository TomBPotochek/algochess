package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.lang.reflect.*;

public class Main extends Application {

	public AlgoChess algoChess;
    public ContenedorTablero contenedorTablero;
    public ContenedorComprarUnidades contenedorComprarUnidades;
    private ContenedorControlesJuego contenedorControlesJuego;
	private Stage stage;
    private Posicion posicionSeleccionada;


	public static void main(String[] args) {

		launch(args);
	}

	public void comenzarJuegoPrincipal() {
		stage.setScene(this.dibujarEscenaJuegoPrincipal());
	}

	public Scene dibujarEscenaJuegoPrincipal() {

		contenedorControlesJuego = new ContenedorControlesJuego(this);
		AnchorPane contenedorPrincipal = new AnchorPane();

		contenedorPrincipal.getChildren().addAll(contenedorControlesJuego.construir(), contenedorTablero.construir());
		return new Scene(contenedorPrincipal);
    }

	public Scene dibujarEscenaArmadoJuego() throws Exception {
		Field field = AlgoChess.class.getDeclaredField("tablero");
		field.setAccessible(true);
		Tablero tablero = (Tablero) field.get(algoChess);

		FlowPane contenedorPrincipal = new FlowPane(Orientation.HORIZONTAL);
		contenedorComprarUnidades = new ContenedorComprarUnidades(this);
		contenedorTablero = new ContenedorTablero(this, tablero);

		contenedorPrincipal.getChildren().addAll(contenedorComprarUnidades.construir(), contenedorTablero.construir());

		return new Scene(contenedorPrincipal);
	}

	public Scene dibujarEscenaSeleccionDeEquipos() {
		FlowPane contenedorSeleccionEquipos = new FlowPane(Orientation.VERTICAL);
		TextField inputEquipo1 = new TextField("Nombre del primer equipo");
		TextField inputEquipo2 = new TextField("Nombre del segundo equipo");
		Button btnEquiposSeleccionados = new Button("Listo!");
		contenedorSeleccionEquipos.setAlignment(Pos.CENTER);
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
		return new Scene(contenedorSeleccionEquipos);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;
		stage.setTitle("AlgoChess");
		Scene escenaSeleccionDeEquipos = dibujarEscenaSeleccionDeEquipos();

        stage.setScene(escenaSeleccionDeEquipos);
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		stage.setWidth(visualBounds.getWidth());
		stage.setHeight(visualBounds.getHeight());
        stage.show();
	}


    public void actualizar() {
	    contenedorComprarUnidades.actualizar(algoChess);
	    contenedorTablero.actualizar();
    }

    public void setPosicionSeleccionada(Posicion posicion) {
	    this.posicionSeleccionada = posicion;
    }

    public Posicion getPosicionSeleccionada() {
	    return this.posicionSeleccionada;
    }
}
