package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.view.CompraDeUnidadesView;
import fiuba.algo3.algochess.view.ContenedorGlobal;

public class CompraDeUnidadesController extends AbstractController {

	private CompraDeUnidadesView vista;
	private AlgoChess algochess;
	public CompraDeUnidadesController(ContenedorGlobal contenedorGlobal, String nombreJugador1, String nombreJugador2) {

		super(contenedorGlobal);
		this.algochess = new AlgoChess(nombreJugador1, nombreJugador2);
		this.vista = new CompraDeUnidadesView(algochess);
	}

	@Override
	public void inicializar() {
		
		this.vista.onComprarCatapultaClick(new ComprarUnidadEventHandler(algochess, "Catapulta"));
		this.vista.onComprarJineteClick(new ComprarUnidadEventHandler(algochess, "Jinete"));
		this.vista.onComprarCuranderoClick(new ComprarUnidadEventHandler(algochess, "Curandero"));
		this.vista.onComprarSoldadoClick(new ComprarUnidadEventHandler(algochess, "Soldado"));
		
		
	}

}
