package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.CasilleroEventHandler;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.unidad.Unidad;
import fiuba.algo3.algochess.view.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CasillaView {
    Casilla casilla;
    Posicion posicion;

    public CasillaView(Casilla casilla, Posicion posicion) {
        this.casilla = casilla;
        this.posicion = posicion;
    }

    public Button construir(Main app) {
        Button button = new Button();
        button.setStyle("-fx-border-color: black");
        button.setAlignment(Pos.CENTER);
        button.setPrefSize(50,50);
        button.setOnAction(new CasilleroEventHandler(app, posicion));
        try {
            String unidad = this.casilla.getUnidad().getClass().getName();
            button.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
        } catch (Exception e) {
            button.setText("-");
        }
        return button;
    }

    public Posicion obtenerPosicion() {
        return posicion;
    }
}
