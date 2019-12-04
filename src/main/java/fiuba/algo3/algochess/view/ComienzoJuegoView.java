package fiuba.algo3.algochess.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;


public class ComienzoJuegoView implements AbstractView {

    private TextField inputEquipo1;
    private TextField inputEquipo2;
    private Button btnEquiposSeleccionados;
	
    public ComienzoJuegoView() {

        inputEquipo1 = new TextField("Nombre jugador 1");
        inputEquipo2 = new TextField("Nombre jugador 2");
        btnEquiposSeleccionados = new Button("Listo!");
    }


	@Override
	public Scene dibujar() {
        FlowPane contenedorSeleccionEquipos = new FlowPane(Orientation.VERTICAL);

        Font inputFont = Font.font(35);

        inputEquipo1.setFont(inputFont);
        inputEquipo2.setFont(inputFont);

        inputEquipo1.setPrefSize(400, 80);
        inputEquipo2.setPrefSize(400, 80);

        btnEquiposSeleccionados.setPrefSize(200, 50);
        btnEquiposSeleccionados.setFont(Font.font(20));
        
        HBox input1Box = new HBox(inputEquipo1);
        HBox input2Box = new HBox(inputEquipo2);
        
        Insets paddingTextos = new Insets(10,0,10,0);
        
        input1Box.setPadding(paddingTextos);
        input2Box.setPadding(paddingTextos);

        contenedorSeleccionEquipos.setAlignment(Pos.CENTER);
        contenedorSeleccionEquipos.getChildren().addAll(input1Box, input2Box, btnEquiposSeleccionados);

        return new Scene(contenedorSeleccionEquipos, 640, 480);
	}
	
	public void onComenzarJuegoClick(EventHandler<ActionEvent> handler) {
		
		btnEquiposSeleccionados.setOnAction(handler);
	}


	public String obtenerNombreJugador1() {

		return inputEquipo1.getText();
	}


	public String obtenerNombreJugador2() {
		
		return inputEquipo2.getText();
	}
	
	
}
