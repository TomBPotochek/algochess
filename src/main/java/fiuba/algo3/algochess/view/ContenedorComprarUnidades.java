package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.controller.ComenzarJuegoEventHandler;
import fiuba.algo3.algochess.controller.ComprarUnidadEventHandler;
import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ContenedorComprarUnidades {

    private VBox contenedor;
    private Text turnoJugador;
    private Text advertencias;
    private Text puntosJ1;
    private Text puntosJ2;

    public ContenedorComprarUnidades(Main app) {
        contenedor = new VBox();
        Text instrucciones = new Text("Primero seleccionar el casillero y despues elegir que unidad comprar");
        turnoJugador = new Text(app.algoChess.obtenerTurno());
        advertencias = new Text();
        this.advertencias.setStyle("-fx-fill: red");
        puntosJ1 = new Text("Puntos restantes de Jugador1");
        puntosJ2 = new Text("Puntos restantes de Jugador2");
        Button btnJinete = new Button("Comprar Jinete");
        btnJinete.setOnAction(new ComprarUnidadEventHandler(app, "Jinete"));
        Button btnSoldado = new Button("Comprar Soldado");
        btnSoldado.setOnAction(new ComprarUnidadEventHandler(app, "Soldado"));
        Button btnCatapulta = new Button("Comprar Catapulta");
        btnCatapulta.setOnAction(new ComprarUnidadEventHandler(app, "Catapulta"));
        Button btnCurandero = new Button("Comprar Curandero");
        btnCurandero.setOnAction(new ComprarUnidadEventHandler(app, "Curandero"));
        btnJinete.setMaxWidth(Double.MAX_VALUE);
        btnSoldado.setMaxWidth(Double.MAX_VALUE);
        btnCatapulta.setMaxWidth(Double.MAX_VALUE);
        btnCurandero.setMaxWidth(Double.MAX_VALUE);

        Button btnComenzarJuego = new Button("Empezar a jugar");
        btnComenzarJuego.setOnAction(new ComenzarJuegoEventHandler(app));

        contenedor.setPadding(new Insets(5,5,5,5));
        contenedor.setSpacing(10);
        contenedor.getChildren().addAll(instrucciones, turnoJugador, btnJinete, btnSoldado, btnCatapulta, btnCurandero, puntosJ1, puntosJ2, advertencias, btnComenzarJuego);
    }

    public VBox construir() {
        return contenedor;
    }


    public void actualizar(AlgoChess algoChess) {
        turnoJugador.setText(algoChess.obtenerTurno());
    }

    public void agregarAdvertencia(String s) {
        this.advertencias.setText(s);
    }
}
