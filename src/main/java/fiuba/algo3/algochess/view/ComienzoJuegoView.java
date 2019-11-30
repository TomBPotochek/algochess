package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

import java.security.PublicKey;

public class ComienzoJuegoView {

    private AlgoChess algoChess;
    private Controller controller;

    public ComienzoJuegoView(Controller controller) {
        this.controller = controller;
    }

    public Scene dibujarEscena() {
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
            controller.comenzarArmadoJuego(inputEquipo1.getText(), inputEquipo2.getText());
        });
        return new Scene(contenedorSeleccionEquipos, 640, 480);
    }
}
