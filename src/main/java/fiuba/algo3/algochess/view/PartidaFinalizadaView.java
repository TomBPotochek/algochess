package fiuba.algo3.algochess.view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;

public class PartidaFinalizadaView implements AbstractView {

	private String jugadorGanador;

	public PartidaFinalizadaView(String jugadorGanador) {

		this.jugadorGanador = jugadorGanador;
	}
	@Override
	public Scene dibujar() {

		FlowPane contenedorPrincipal = new FlowPane();

		Text texto1 = new Text("¡Ha terminado la partida! \n" + "El ganador es "  + this.jugadorGanador);

		Font font = Font.font("Arial", FontWeight.BOLD, 55);
		texto1.setFont(font);
		texto1.setFill(Color.YELLOW);
		StackPane panel = new StackPane();
		panel.getChildren().add(texto1);
		Image imagen = new Image("victoria.jpg");

		panel.setBackground(new Background(new BackgroundImage(imagen, null, null, null, null)));
		StackPane.setAlignment(texto1, Pos.CENTER);
		panel.setPrefSize(Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
		contenedorPrincipal.getChildren().addAll(panel);
		
		return new Scene(contenedorPrincipal, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());
	}

}
