package fiuba.algo3.algochess.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CasilleroEventHandler implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        String textoClickeado = "¡ Me han clickeado !";
        System.out.println(textoClickeado);
    }

}
