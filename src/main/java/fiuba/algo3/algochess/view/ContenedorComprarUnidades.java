package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.ComprarUnidadEventHandler;
import fiuba.algo3.algochess.controller.Controller;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorComprarUnidades extends Contenedor {

    private String unidadSeleccionada = "";
    private Text turnoJugador;
    private Text advertencias;
    private Text puntosJugador;

    public ContenedorComprarUnidades(Controller controller) {
        contenedor = new VBox();
        advertencias = new Text();
        advertencias.setFill(Color.RED);
        turnoJugador = new Text();
        puntosJugador = new Text(); 
        actualizar(controller.algoChess);
        Button btnJinete = new Button("Comprar Jinete");
        btnJinete.setOnAction(new ComprarUnidadEventHandler(controller, "Jinete"));
        Button btnSoldado = new Button("Comprar Soldado");
        btnSoldado.setOnAction(new ComprarUnidadEventHandler(controller, "Soldado"));
        Button btnCatapulta = new Button("Comprar Catapulta");
        btnCatapulta.setOnAction(new ComprarUnidadEventHandler(controller, "Catapulta"));
        Button btnCurandero = new Button("Comprar Curandero");
        btnCurandero.setOnAction(new ComprarUnidadEventHandler(controller, "Curandero"));
        btnJinete.setMaxWidth(Double.MAX_VALUE);
        btnSoldado.setMaxWidth(Double.MAX_VALUE);
        btnCatapulta.setMaxWidth(Double.MAX_VALUE);
        btnCurandero.setMaxWidth(Double.MAX_VALUE);

        Button btnComenzarJuegoPrincipal = new Button("Jugar!");
        btnComenzarJuegoPrincipal.setOnAction(e -> controller.comenzarJuegoPrincipal());

        contenedor.getChildren().addAll(turnoJugador, btnJinete, btnSoldado, btnCatapulta, btnCurandero, puntosJugador, advertencias, btnComenzarJuegoPrincipal);
    }

    public String obtenerNombreUnidadSeleccionada() {
        return unidadSeleccionada;
    }

    @Override
    public void actualizar(AlgoChess algoChess) {
        turnoJugador.setText(algoChess.obtenerEquipoTurnoActual());
        puntosJugador.setText("Puntos restantes: " + String.valueOf(algoChess.obtenerPuntosTurnoActual()));
    }

    public void setNombreUnidadSeleccionada(String nombreUnidad) {
        this.unidadSeleccionada = nombreUnidad;
    }

    public void agregarAdvertencia(String s) {
        this.advertencias.setText(s);
    }
}
