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
            this.boton.setGraphic(new ImageView(new Image(nombreArchivo+".png",width-2,width-2,false,false)));
            //boton.setText(String.valueOf(unidad.charAt(35))); // fiuba.algo3.algochess.model.unidad.Soldado hay 35 caracteres hasta la primera letra del nombre de la unidad
            //this.crearBarravida(unidad);
            
        } catch (CasillaLibreException e) {
            boton.setGraphic(null);
        }

	}
	
	private String elegirImagen(Unidad unidad) {
		/*Class<?> unidadClass = unidad.getClass();
		Field campo = unidadClass.getDeclaredField("equipo");
		campo.setAccessible(true);
		String nombreJugador = (String) campo.get(unidad);
		System.out.println(nombreJugador);
		String color = this.colores.get(nombreJugador);
		String nombreUnidad = unidadClass.getName();
		String nombreArchivo = nombreUnidad.substring(36);
		return nombreArchivo+"_"+color;*/
		Class<?> unidadClass = unidad.getClass();
		String nombreJugador = unidad.getEquipo().obtenerNombre();
		String color = this.colores.get(nombreJugador);
		String nombreUnidad = unidadClass.getName();
		String nombreArchivo = nombreUnidad.substring(35);
		return nombreArchivo+"_"+color;
		
		
	}
	
	// WIP
	/* 
	private void crearBarravida(Unidad unidad) {
		try {	
			Class<?> unidadClass = unidad.getClass();
			Field vidaFull = unidadClass.getDeclaredField("vidaInicial");
			Field vidaActual = unidadClass.getDeclaredField("vidaRestante");
			vidaFull.setAccessible(true);
			vidaActual.setAccessible(true);
			float vidaInicial = (float) vidaFull.get(unidad);
			float vidaRestante = (float) vidaActual.get(unidad);
			float porcentaje = (float) (100*vidaRestante/vidaInicial);
			
			
			Rectangle barraVida = new Rectangle(50.0, 5.0, Color.RED);
			DoubleProperty porcentajeVida = new SimpleDoubleProperty(porcentaje);
			DoubleBinding b1 = barraVida.widthProperty().multiply(porcentajeVida);
			barraVida.widthProperty().bind(b1);
		} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {System.out.println(e.getMessage());}
	}*/

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
