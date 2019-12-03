package fiuba.algo3.algochess.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorControlesJuego extends Contenedor {

    GridPane grillaFlechas;
    Button btnFlechaNorte;
    Button btnFlechaNorEste;
    Button btnFlechaEste;
    Button btnFlechaSurEste;
    Button btnFlechaSur;
    Button btnFlechaSurOeste;
    Button btnFlechaOeste;
    Button btnFlechaNorOeste;
    private Text advertencias;

    public ContenedorControlesJuego() {
        contenedor = new VBox();
        Button btnAtaque = new Button("Atacar");

        grillaFlechas = new GridPane();
        btnFlechaNorte = new Button("->");
        grillaFlechas.add(btnFlechaNorte, 1, 0);
        btnFlechaNorEste = new Button("->");
        grillaFlechas.add(btnFlechaNorEste, 2, 0);
        btnFlechaEste = new Button("->");
        grillaFlechas.add(btnFlechaEste, 2, 1);
        btnFlechaSurEste = new Button("->");
        grillaFlechas.add(btnFlechaSurEste, 2, 2);
        btnFlechaSur = new Button("->");
        grillaFlechas.add(btnFlechaSur, 1, 2);
        btnFlechaSurOeste = new Button("->");
        grillaFlechas.add(btnFlechaSurOeste, 0, 2);
        btnFlechaOeste = new Button("->");
        grillaFlechas.add(btnFlechaOeste, 0, 1);
        btnFlechaNorOeste = new Button("->");
        grillaFlechas.add(btnFlechaNorOeste, 0, 0);

        advertencias = new Text();

        contenedor.getChildren().addAll(btnAtaque, grillaFlechas, advertencias);
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
}
