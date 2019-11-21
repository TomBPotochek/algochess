package fiuba.algo3.algochess.vista;

import fiuba.algo3.algochess.modelo.tablero.Tablero;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class TableroView extends Group {

    private double altura;
    private double ancho;
    private double altoCasilla = 64;
    private double anchoCasilla = 64;

    private GridPane table;
    private Pane[][] panes;

    public TableroView(Tablero tablero){
        table = new GridPane();
        altura = altoCasilla * tablero.getTamanio();
        ancho = anchoCasilla * tablero.getTamanio();
        panes = new Pane[(int)ancho][(int)altura];

        for (int i = 0; i < tablero.getTamanio(); i++){
            for (int j = 0; j < tablero.getTamanio(); j++){
                Pane v = new Pane();
                v.setBackground(new Background(new BackgroundFill(Color.rgb(10*i, 10*j, 20), CornerRadii.EMPTY, Insets.EMPTY)));
                v.setMinHeight(this.altoCasilla);
                v.setMinWidth(this.anchoCasilla);
                panes[i][j] = v;
                table.add(v, i, j);
            }
        }
        this.getChildren().add(table);
    }

}
