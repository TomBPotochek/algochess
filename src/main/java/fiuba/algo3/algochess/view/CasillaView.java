package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.CasilleroEventHandler;
import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CasillaView {
    Casilla casilla;
    Posicion posicion;
    Button boton;

    public CasillaView(Casilla casilla, Posicion posicion) {
        this.casilla = casilla;
        this.posicion = posicion;
    }

    public Button construir(Controller controller) {
        Button button = new Button();
        button.setStyle("-fx-border-color: black");
        button.setAlignment(Pos.CENTER);
        button.setPrefSize(50,50);
        button.setOnAction(new CasilleroEventHandler(controller, posicion));
        try {
            String unidad = this.casilla.getUnidad().getClass().getName();
            button.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
            button.setUserData(posicion);
        } catch (Exception e) {
            button.setText("-");
        }
        if(posicion.equals(controller.getPosicionSeleccionada())) button.setStyle("-fx-background-color: #4AB43F");
        return button;
    }

    public Posicion obtenerPosicion() {
        return posicion;
    }
    
    public void onCasillaClick(EventHandler<ActionEvent> e) {

    	boton.setOnAction(e);
    }
}
