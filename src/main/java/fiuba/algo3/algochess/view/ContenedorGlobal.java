package fiuba.algo3.algochess.view;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContenedorGlobal {
    private Stage stage;
    Contenedor contenedorLateral;
    ContenedorTablero contenedorTablero;
    BorderPane contenedorPrincipal;

    public ContenedorGlobal(Stage stage) {
        this.stage = stage;
    }

    public void set(ComienzoJuegoView comienzoJuegoView)  {
        stage.setScene(comienzoJuegoView.dibujarEscena());
    }

    public void set(Contenedor contenedorLateral, ContenedorTablero contenedorTablero) {
        this.contenedorLateral = contenedorLateral;
        this.contenedorTablero = contenedorTablero;
        this.contenedorPrincipal = new BorderPane();
        Pane lateralBox = contenedorLateral.dibujar();
        Pane tableroBox = contenedorTablero.dibujar();
        lateralBox.setPrefWidth(400);
        lateralBox.setPadding(new Insets(20,20,20,20));
        tableroBox.setPadding(new Insets(20,20,20,20));
        this.contenedorPrincipal.setLeft(lateralBox);
        this.contenedorPrincipal.setCenter(tableroBox);
        this.contenedorPrincipal.setPrefSize(stage.getWidth(), stage.getHeight());
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
