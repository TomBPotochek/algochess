package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ContenedorControlesJuego extends Contenedor {

    GridPane grillaFlechas;

    public ContenedorControlesJuego(Controller controller) {
        contenedor = new VBox();
        Button btnAtaque = new Button("Atacar");
        Button btnFlecha;

        grillaFlechas = new GridPane();
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                btnFlecha = new Button("->");
//                btnFlecha.setOnAction(new FlechaEventHandler(controller, new Direccion(i-1, j-1)));
                grillaFlechas.add(btnFlecha, i, j);
            }
        }

        contenedor.getChildren().addAll(btnAtaque, grillaFlechas);
    }
}
