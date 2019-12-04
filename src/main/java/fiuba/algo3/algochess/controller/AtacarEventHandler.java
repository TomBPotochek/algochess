package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.model.tablero.Tablero;
import fiuba.algo3.algochess.view.BatallaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class AtacarEventHandler implements EventHandler<ActionEvent>  {

    private BatallaView vista;
    private TurnoActual turnoActual;

    public AtacarEventHandler(TurnoActual turnoActual, BatallaView vista) {
        this.turnoActual = turnoActual;
        this.vista = vista;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        vista.pintarTablero();

        vista.onCasillaClick(e -> {

            Posicion posicion = (Posicion) ((Node) e.getSource()).getUserData();

            vista.onCasillaClick(e2 -> {

                Posicion posicionEnemigo = (Posicion) ((Node) e2.getSource()).getUserData();

                try {
                    turnoActual.atacar(posicion, posicionEnemigo);

                } catch (Exception ex) {
                    vista.mostrarError(ex.getMessage());
                }

            });
        });
    }



}
