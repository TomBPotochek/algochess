package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.Observer;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        this.turnoActual = turnoActual;
        this.turnoActual.addObserver(this);
        turnoJugador = new Text();
        advertencias = new Text();
        advertencias.setFill(Color.RED);
        contenedor = new VBox();
        btnAtaque = new Button("Atacar");

        actualizar();

        grillaFlechas = new GridPane();
        btnFlechaNorte = new Button("->");
        grillaFlechas.add(btnFlechaNorte, 1, 2);
        btnFlechaNorEste = new Button("->");
        grillaFlechas.add(btnFlechaNorEste, 2, 2);
        btnFlechaEste = new Button("->");
        grillaFlechas.add(btnFlechaEste, 2, 1);
        btnFlechaSurEste = new Button("->");
        grillaFlechas.add(btnFlechaSurEste, 2, 0);
        btnFlechaSur = new Button();
        btnFlechaSur.setGraphic(new ImageView(new Image("flecha.png")));
        grillaFlechas.add(btnFlechaSur, 1, 0);
        btnFlechaSurOeste = new Button("->");
        grillaFlechas.add(btnFlechaSurOeste, 0, 0);
        btnFlechaOeste = new Button("->");
        grillaFlechas.add(btnFlechaOeste, 0, 1);
        btnFlechaNorOeste = new Button("->");
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
