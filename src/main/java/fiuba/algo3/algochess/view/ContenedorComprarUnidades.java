package fiuba.algo3.algochess.view;


import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorComprarUnidades extends Contenedor implements Observer {

	private TurnoActual turnoActual;
    private String unidadSeleccionada = "";
    private Text turnoJugador;
    private Text advertencias;
    private Text puntosJugador;
    private Button btnJinete;
    private Button btnSoldado;
    private Button btnCatapulta;
    private Button btnCurandero;
    private Button btnComenzarBatalla;

    public ContenedorComprarUnidades(TurnoActual turnoActual) {
        this.turnoActual = turnoActual;
        this.turnoActual.addObserver(this);
    	contenedor = new VBox();
        advertencias = new Text();
        advertencias.setFill(Color.RED);
        turnoJugador = new Text();
        puntosJugador = new Text(); 
        actualizar();
        btnJinete = new Button("Comprar Jinete");
        btnSoldado = new Button("Comprar Soldado");
        btnCatapulta = new Button("Comprar Catapulta");
        btnCurandero = new Button("Comprar Curandero");
        btnJinete.setMaxWidth(Double.MAX_VALUE);
        btnSoldado.setMaxWidth(Double.MAX_VALUE);
        btnCatapulta.setMaxWidth(Double.MAX_VALUE);
        btnCurandero.setMaxWidth(Double.MAX_VALUE);

        btnComenzarBatalla = new Button("Jugar!");

        contenedor.getChildren().addAll(turnoJugador, btnJinete, btnSoldado, btnCatapulta, btnCurandero, puntosJugador, advertencias, btnComenzarBatalla);
    }

    public String obtenerNombreUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    @Override
    public void actualizar() {
        turnoJugador.setText(turnoActual.getEquipo().obtenerNombre());
        puntosJugador.setText("Puntos restantes: " + String.valueOf(turnoActual.obtenerPuntos()));
        advertencias.setText("");
    }

    public void setNombreUnidadSeleccionada(String nombreUnidad) {
        this.unidadSeleccionada = nombreUnidad;
    }

    public void agregarAdvertencia(String s) {
        this.advertencias.setText(s);
    }
    
    public void onComprarJineteClick(EventHandler<ActionEvent> e) {
    	
    	this.btnJinete.setOnAction(e);
    }
    
    public void onComprarSoldadoClick(EventHandler<ActionEvent> e) {
    	
    	this.btnSoldado.setOnAction(e);
    }

    public void onComprarCatapultaClick(EventHandler<ActionEvent> e) {
    	
    	this.btnCatapulta.setOnAction(e);
    }

    public void onComprarCuranderoClick(EventHandler<ActionEvent> e) {
    	
    	this.btnCurandero.setOnAction(e);
    }
    
    public void onComenzarBatallaClick(EventHandler<ActionEvent> e) {
    	
    	this.btnComenzarBatalla.setOnAction(e);
    }
    
    public void mostrarError(String error) {
 
    	this.advertencias.setText(error);
    }
}
