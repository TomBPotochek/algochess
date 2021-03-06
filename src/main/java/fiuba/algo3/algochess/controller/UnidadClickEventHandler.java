package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.BatallaView;
import fiuba.algo3.algochess.view.ContenedorGlobal;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class UnidadClickEventHandler implements EventHandler<ActionEvent> {

	private BatallaView vista;
	private TurnoActual turnoActual;
	private ContenedorGlobal contenedorGlobal;
	
	public UnidadClickEventHandler(BatallaView vista, TurnoActual turnoActual, ContenedorGlobal contenedorGlobal) {

		this.vista = vista;
		this.turnoActual = turnoActual;
		this.contenedorGlobal = contenedorGlobal;
	}
	@Override
	public void handle(ActionEvent e) {

		vista.habilitarControles();
		
		Posicion posSeleccionada = (Posicion) ((Node) e.getSource()).getUserData();

		vista.onAtacarClick(new AtacarEventHandler(turnoActual, vista, posSeleccionada, contenedorGlobal));	
		vista.onMoverNorteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.N, posSeleccionada));
		vista.onMoverNorEsteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.NE, posSeleccionada));
		vista.onMoverEsteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.E, posSeleccionada));
		vista.onMoverSurEsteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.SE, posSeleccionada));
		vista.onMoverSurClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.S, posSeleccionada));
		vista.onMoverSurOesteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.SO, posSeleccionada));
		vista.onMoverOesteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.O, posSeleccionada));
		vista.onMoverNorOesteClick(new MoverUnidadEventHandler(turnoActual, vista, Direccion.NO, posSeleccionada));
		
	}

}
