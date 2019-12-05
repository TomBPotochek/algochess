package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.juego.TurnoActual;
import fiuba.algo3.algochess.view.CompraDeUnidadesView;
import fiuba.algo3.algochess.view.ContenedorGlobal;
import java.util.HashMap;

public class CompraDeUnidadesController extends AbstractController {

	private CompraDeUnidadesView vista;
	private AlgoChess algochess;
	private HashMap<String,String> coloresEquipo = new HashMap<String,String>();

	public CompraDeUnidadesController(ContenedorGlobal contenedorGlobal, String nombreJugador1, String nombreJugador2) {
		super(contenedorGlobal);
		this.algochess = new AlgoChess(nombreJugador1, nombreJugador2);
		this.coloresEquipo.put(nombreJugador1, "AZUL");
		this.coloresEquipo.put(nombreJugador2, "NARANJA");
		this.vista = new CompraDeUnidadesView(algochess,this.coloresEquipo);
		
	}

	@Override
	public void inicializar() {
		
		this.vista.onComprarCatapultaClick(new ComprarUnidadEventHandler(algochess.getTurnoActual(), this.vista, "Catapulta"));
		this.vista.onComprarJineteClick(new ComprarUnidadEventHandler(algochess.getTurnoActual(), this.vista, "Jinete"));
		this.vista.onComprarCuranderoClick(new ComprarUnidadEventHandler(algochess.getTurnoActual(), this.vista, "Curandero"));
		this.vista.onComprarSoldadoClick(new ComprarUnidadEventHandler(algochess.getTurnoActual(), this.vista, "Soldado"));

		this.vista.onComenzarBatallaClick(e -> {
			
			TurnoActual turnoActual = algochess.getTurnoActual();
			turnoActual.finalizarCompra();
			
			if (turnoActual.jugadoresListos()) {
				
				BatallaController siguiente = new BatallaController(contenedorGlobal, algochess, coloresEquipo);
				
				siguiente.inicializar();
			}
		});

		this.renderizar(this.vista);
	}

}
