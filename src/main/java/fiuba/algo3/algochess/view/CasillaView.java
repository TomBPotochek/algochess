package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

public class CasillaView implements Observer {
    Casilla casilla;
    Posicion posicion;
    Button boton;
    TurnoActual turnoActual;

    public CasillaView(TurnoActual turnoActual, Casilla casilla, Posicion posicion) {
        this.casilla = casilla;
        this.posicion = posicion;
        this.turnoActual = turnoActual;
        
        this.boton = new Button();
        this.actualizar();

        this.casilla.addObserver(this);
        this.turnoActual.addObserver(this);
    }

    public Button construir() {

        return boton;
    }

    public Posicion obtenerPosicion() {
        return posicion;
    }
    
	public void onClick(EventHandler<ActionEvent> e) {
		
		boton.setOnAction(e);
	}

	@Override
	public void actualizar() {

        String backgroundColor = casilla.esAliada(this.turnoActual.getEquipo()) ? "#56ff00" : "#ff0000";
        boton.setStyle("-fx-border-color: black; -fx-background-color: " + backgroundColor + ";");
        boton.setAlignment(Pos.CENTER);
        boton.setPrefSize(50,50);

        try {
            String unidad = this.casilla.getUnidad().getClass().getName();
            boton.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
            boton.setUserData(posicion);
        } catch (Exception e) {
            boton.setText("-");
        }

	}
}
