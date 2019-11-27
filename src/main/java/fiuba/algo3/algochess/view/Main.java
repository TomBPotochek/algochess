package fiuba.algo3.algochess.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}
	
	@Override
	public void start(Stage stage) {

		BorderPane contenedorPrincipal = new BorderPane();
		VBox contenedorControles = new VBox();
		GridPane contenedorTablero = new GridPane();

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

		for(int i = 0; i < 20; i++) {
		    for(int j = 0; j < 20; j++) {
		        Button casillero = new Button(Integer.toString(i) + " : " + Integer.toString(j) );
		        casillero.setPrefSize(50,50);
                contenedorTablero.add(casillero , i, j);
            }
        }

		contenedorPrincipal.setLeft(contenedorControles);
		contenedorPrincipal.setRight(contenedorTablero);

		Scene scene = new Scene(contenedorPrincipal, 640, 480);
        stage.setScene(scene);
        stage.show();
	}

	
}
