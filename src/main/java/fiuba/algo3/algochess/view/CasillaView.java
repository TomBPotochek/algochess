package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.excepciones.CasillaLibreException;
import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Casilla;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.unidad.Unidad;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.paint.Color; 
import javafx.scene.shape.Rectangle;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.binding.DoubleBinding;
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
		
        String backgroundColor = casilla.esAliada(this.turnoActual.getEquipo()) ? "#56ff00" : "#ff0000";
        boton.setStyle("-fx-border-color: black; -fx-background-color: " + backgroundColor + ";");
        boton.setAlignment(Pos.CENTER);
        boton.setPrefSize(width, width);
        boton.setUserData(posicion);

        try {
            Unidad unidad = this.casilla.getUnidad();
            String nombreArchivo = elegirImagen(unidad);
            /*Background bi = new Background(new BackgroundImage(new Image(nombreArchivo+".png"),BackgroundRepeat.NO_REPEAT,
            		BackgroundRepeat.NO_REPEAT,
            		BackgroundPosition.CENTER,
            		new BackgroundSize(50, 50, false, false, false, false) ));*/
            this.boton.setGraphic(new ImageView(new Image(nombreArchivo)));
            //boton.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
            
        } catch (Exception e) {
            boton.setText("-");
        }

	}
	
	private String elegirImagen(Unidad unidad) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException {
		Class unidadClass = unidad.getClass();
		String nombreJugador =(String) unidadClass.getDeclaredField("equipo").get(unidad);
		String color = this.colores.get(nombreJugador);
		String nombreUnidad = unidadClass.getName();
		String nombreArchivo = nombreUnidad.substring(36);
		return nombreArchivo+"_"+color;
		
	}
	
	/*
	private void crearBarravida() {
		Rectangle barraVida = new Rectangle(50.0, 5.0, Color.RED);
		DoubleProperty porcentajeVida = new SimpleDoubleProperty(1.0);
		DoubleBinding b1 = barraVida.widthProperty().multiply(porcentajeVida);
		barraVida.widthProperty().bind(b1);
	}*/

	public void onUnidadClick(EventHandler<ActionEvent> e) {
		
		try {
			this.casilla.getUnidad();
			this.boton.setOnAction(e);
		
		} catch (CasillaLibreException ex) {}
		
	}
}
