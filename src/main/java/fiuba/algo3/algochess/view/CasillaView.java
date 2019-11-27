package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.tablero.Casilla;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CasillaView {
    Casilla casilla;

    public CasillaView(Casilla casilla) {
        this.casilla = casilla;

    }

    public Button construir() {
        Button button = new Button();
        button.setStyle("-fx-border-color: black");
        button.setAlignment(Pos.CENTER);
        button.setPrefSize(50,50);
        // casillero.setOnAction(new CasilleroEventHandler());
        return button;
    }
}
