package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class ContenedorGlobal {
    private Stage stage;
    Contenedor contenedorLateral;
    ContenedorTablero contenedorTablero;
    FlowPane contenedorPrincipal;

    public ContenedorGlobal(Stage stage) {
        this.stage = stage;
    }

    public void set(ComienzoJuegoView comienzoJuegoView)  {
        stage.setScene(comienzoJuegoView.dibujarEscena());
    }

    public void set(Contenedor contenedorLateral, ContenedorTablero contenedorTablero) {
        this.contenedorLateral = contenedorLateral;
        this.contenedorTablero = contenedorTablero;
        this.contenedorPrincipal = new FlowPane();
        this.contenedorPrincipal.getChildren().addAll(contenedorLateral.dibujar(), contenedorTablero.dibujar());
        stage.setScene(new Scene(contenedorPrincipal));
    }


    public void agregarAdvertencia(String advertencia) {
        ((ContenedorComprarUnidades) contenedorLateral).agregarAdvertencia(advertencia);
    }

    public void actualizar(AlgoChess algoChess) {
        contenedorLateral.actualizar(algoChess);
        contenedorTablero.actualizar(algoChess);
    }
}
