package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.SeleccionEquiposController;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public ContenedorTablero contenedorTablero;
    public ContenedorComprarUnidades contenedorComprarUnidades;

	public static void main(String[] args) {

		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("AlgoChess");
        stage.setMaximized(true);
        SeleccionEquiposController controller = new SeleccionEquiposController(new ContenedorGlobal(stage));
		controller.inicializar();

        stage.show();
	}

}
