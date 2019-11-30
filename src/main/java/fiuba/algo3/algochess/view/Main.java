package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

	public AlgoChess algoChess;
    public ContenedorTablero contenedorTablero;
    public ContenedorComprarUnidades contenedorComprarUnidades;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("AlgoChess");
        stage.setMaximized(true);
        Controller controller = new Controller(new ContenedorGlobal(stage));
		controller.comenzarSeleccionEquipos();

        stage.show();
	}

}
