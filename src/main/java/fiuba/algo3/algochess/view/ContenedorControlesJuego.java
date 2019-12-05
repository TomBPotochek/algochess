package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorControlesJuego extends Contenedor implements Observer {

    private TurnoActual turnoActual;
    private Text turnoJugador;
    private Text advertencias;
    private GridPane grillaFlechas;
    private Button btnFlechaNorte;
    private Button btnFlechaNorEste;
    private Button btnFlechaEste;
    private Button btnFlechaSurEste;
    private Button btnFlechaSur;
    private Button btnFlechaSurOeste;
    private Button btnFlechaOeste;
    private Button btnFlechaNorOeste;
    private Button btnAtaque;

    public ContenedorControlesJuego(TurnoActual turnoActual) {
    	final int width = 35;
        
    	
    	this.turnoActual = turnoActual;
        this.turnoActual.addObserver(this);
        turnoJugador = new Text();
        advertencias = new Text();
        advertencias.setFill(Color.RED);
        contenedor = new VBox();
        
        btnAtaque = new Button("Atacar");
        btnAtaque.setPrefSize(2*width, width);

        actualizar();
        

        grillaFlechas = new GridPane();
        
        btnFlechaNorte = new Button();
        btnFlechaNorte.setGraphic(new ImageView(new Image("flecha_S.png",width-2,width-2,false,false)));
        btnFlechaNorte.setPadding(new Insets(0));
        btnFlechaNorte.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaNorte, 1, 2);
        
        btnFlechaNorEste = new Button();
        btnFlechaNorEste.setGraphic(new ImageView(new Image("flecha_SE.png",width-2,width-2,false,false)));
        btnFlechaNorEste.setPadding(new Insets(0));
        btnFlechaNorEste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaNorEste, 2, 2);
        
        btnFlechaEste = new Button();
        btnFlechaEste.setGraphic(new ImageView(new Image("flecha_E.png",width-2,width-2,false,false)));
        btnFlechaEste.setPadding(new Insets(0));
        btnFlechaEste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaEste, 2, 1);
        
        btnFlechaSurEste = new Button();
        btnFlechaSurEste.setGraphic(new ImageView(new Image("flecha_NE.png",width-2,width-2,false,false)));
        btnFlechaSurEste.setPadding(new Insets(0));
        btnFlechaSurEste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaSurEste, 2, 0);
        
        btnFlechaSur = new Button();
        btnFlechaSur.setGraphic(new ImageView(new Image("flecha_N.png",width-2,width-2,false,false)));
        btnFlechaSur.setPadding(new Insets(0));
        btnFlechaSur.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaSur, 1, 0);
        
        btnFlechaSurOeste = new Button();
        btnFlechaSurOeste.setGraphic(new ImageView(new Image("flecha_NO.png",width-2,width-2,false,false)));
        btnFlechaSurOeste.setPadding(new Insets(0));
        btnFlechaSurOeste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaSurOeste, 0, 0);
        
        btnFlechaOeste = new Button();
        btnFlechaOeste.setGraphic(new ImageView(new Image("flecha_O.png",width-2,width-2,false,false)));
        btnFlechaOeste.setPadding(new Insets(0));
        btnFlechaOeste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaOeste, 0, 1);
        
        btnFlechaNorOeste = new Button();
        btnFlechaNorOeste.setGraphic(new ImageView(new Image("flecha_SO.png",width-2,width-2,false,false)));
        btnFlechaNorOeste.setPadding(new Insets(0));
        btnFlechaNorOeste.setPrefSize(width, width);
        grillaFlechas.add(btnFlechaNorOeste, 0, 2);

        contenedor.getChildren().addAll(turnoJugador, btnAtaque, grillaFlechas, advertencias);
    }

    public void actualizar() {

        turnoJugador.setText(turnoActual.getEquipo().obtenerNombre());
        advertencias.setText("");
    }

    public void onAtacarClick(EventHandler<ActionEvent> e) {
        this.btnAtaque.setOnAction(e);
    }

    public void onMoverNorteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaNorte.setOnAction(e);
    }
    public void onMoverNorEsteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaNorEste.setOnAction(e);
    }
    public void onMoverEsteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaEste.setOnAction(e);
    }
    public void onMoverSurEsteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaSurEste.setOnAction(e);
    }
    public void onMoverSurClick(EventHandler<ActionEvent> e) {
        this.btnFlechaSur.setOnAction(e);
    }
    public void onMoverSurOesteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaSurOeste.setOnAction(e);
    }
    public void onMoverOesteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaOeste.setOnAction(e);
    }
    public void onMoverNorOesteClick(EventHandler<ActionEvent> e) {
        this.btnFlechaNorOeste.setOnAction(e);
    }

    public void mostrarError(String error) {
        this.advertencias.setText(error);
    }

	public void deshabilitarControles(boolean deshabilitar) {
		    this.btnFlechaNorte.setDisable(deshabilitar);
		    this.btnFlechaNorEste.setDisable(deshabilitar);
		    this.btnFlechaEste.setDisable(deshabilitar);
		    this.btnFlechaSurEste.setDisable(deshabilitar);
		    this.btnFlechaSur.setDisable(deshabilitar);
		    this.btnFlechaSurOeste.setDisable(deshabilitar);
		    this.btnFlechaOeste.setDisable(deshabilitar);
		    this.btnFlechaNorOeste.setDisable(deshabilitar);
		    this.btnAtaque.setDisable(deshabilitar);
	}
}
