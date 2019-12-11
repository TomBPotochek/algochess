package fiuba.algo3.algochess.controller;


import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.model.tablero.Posicion;
import fiuba.algo3.algochess.view.BatallaView;
import fiuba.algo3.algochess.view.ContenedorGlobal;
import fiuba.algo3.algochess.view.PartidaFinalizadaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

public class AtacarEventHandler implements EventHandler<ActionEvent>  {

    private BatallaView vista;
    private TurnoActual turnoActual;
    private Posicion posicionUnidad;
	private ContenedorGlobal contenedorGlobal;

    public AtacarEventHandler(TurnoActual turnoActual, BatallaView vista, Posicion posicionUnidad, ContenedorGlobal contenedorGlobal) {
        this.turnoActual = turnoActual;
        this.vista = vista;
        this.posicionUnidad = posicionUnidad;
        this.contenedorGlobal =  contenedorGlobal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {


        vista.onCasillaClick(e -> {

            Posicion posicionEnemigo = (Posicion) ((Node) e.getSource()).getUserData();

            try {

            	vista.onUnidadClick(new UnidadClickEventHandler(vista, turnoActual, contenedorGlobal));

            	Util.reproducirSonido("Catapulta.mp3");
                turnoActual.atacar(posicionUnidad, posicionEnemigo);
                
                vista.deshabilitarControles();
                
                if (turnoActual.finalizoPartida()) {

                	Util.reproducirSonido("victoria.mp3");

                	PartidaFinalizadaView vistaFinal = new PartidaFinalizadaView(turnoActual.getEquipo().obtenerNombre());
                	this.contenedorGlobal.cambiarEscena(vistaFinal.dibujar());
                	
                }
                	
            } catch (Exception ex) {
                vista.mostrarError(ex.getMessage());
            }

        });
    }
}
