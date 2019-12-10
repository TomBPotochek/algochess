package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;

public class CasillaView implements Observer {
    Casilla casilla;
    Posicion posicion;
    Button boton;
    TurnoActual turnoActual;
    HashMap<String,String> colores;

    public CasillaView(TurnoActual turnoActual, Casilla casilla, Posicion posicion, HashMap<String,String> colores) {
        this.casilla = casilla;
        this.posicion = posicion;
        this.turnoActual = turnoActual;
        this.colores = colores;
        
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
		final int width = 50;
		final int height = 50;
		
        String backgroundColor = colores.get(this.casilla.getEquipo().obtenerNombre()) == "AZUL" ? "#0000ff" : "#ff7400";
        boton.setStyle("-fx-border-color: black; -fx-background-color: " + backgroundColor + ";");
        boton.setAlignment(Pos.CENTER);
        boton.setPrefSize(width, height);
        boton.setPadding(new Insets(0));
        boton.setUserData(posicion);

        try {
            Unidad unidad = this.casilla.getUnidad();
            String nombreArchivo = elegirImagen(unidad);
            ImageView figura = new ImageView(new Image(nombreArchivo+".png",width-2,width-2,false,false));
            String vida = String.valueOf(unidad.getVidaRestante());
            this.boton.setGraphic(figura);
            this.boton.setTooltip(new Tooltip(vida));
            
        } catch (CasillaLibreException e) {
            boton.setGraphic(null);
        }

	}
	
	private String elegirImagen(Unidad unidad) {

		Class<?> unidadClass = unidad.getClass();
		String nombreJugador = unidad.getEquipo().obtenerNombre();
		String color = this.colores.get(nombreJugador);
		String nombreUnidad = unidadClass.getName();
		String nombreArchivo = nombreUnidad.substring(35);
		return nombreArchivo+"_"+color;
		
		
	}
	
	public void onUnidadClick(EventHandler<ActionEvent> e) {
		
		try {
			this.casilla.getUnidad();
			this.boton.setOnAction(evt -> {
				this.boton.setStyle("-fx-border-color: white");
				e.handle(evt);
			});
		
		} catch (CasillaLibreException ex) {}
		
	}

	public void deshabilitar() {

		this.boton.setDisable(true);
	}
}
