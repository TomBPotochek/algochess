package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CasillaView {
    Casilla casilla;
    Posicion posicion;
    Button boton;
    TurnoActual turnoActual;

    public CasillaView(TurnoActual turnoActual, Casilla casilla, Posicion posicion) {
        this.casilla = casilla;
        this.posicion = posicion;
        this.turnoActual = turnoActual;
        
        // TODO: observar a turnoActual
    }

    public Button construir() {
        Button button = new Button();
        String backgroundColor = casilla.esAliada(this.turnoActual.getEquipo()) ? "#56ff00" : "#ff0000";
        button.setStyle("-fx-border-color: black; -fx-background-color: " + backgroundColor + ";");
        button.setAlignment(Pos.CENTER);
        button.setPrefSize(50,50);

        try {
            String unidad = this.casilla.getUnidad().getClass().getName();
            button.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
            button.setUserData(posicion);
        } catch (Exception e) {
            button.setText("-");
        }
        return button;
    }

    public Posicion obtenerPosicion() {
        return posicion;
    }
    
	public void onClick(EventHandler<ActionEvent> e) {
		
		boton.setOnAction(e);
	}
}
