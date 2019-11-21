package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.juego.Equipo;
import fiuba.algo3.algochess.modelo.tablero.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    private TableroView tableroView;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage theStage) {
        theStage.setTitle("AlgoChess");

        Equipo equipo1 = new Equipo("Equipo1");
        Equipo equipo2 = new Equipo("Equipo2");
        Tablero tablero = new Tablero(10, equipo1, equipo2);
        tableroView = new TableroView(tablero);

        VBox vbox = new VBox();

        vbox.getChildren().add(tableroView);

        Scene theScene = new Scene(vbox);
        theStage.setScene(theScene);
        theStage.show();
    }
}
