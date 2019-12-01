package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.view.ComienzoJuegoView;
import fiuba.algo3.algochess.view.ContenedorGlobal;

public class SeleccionEquiposController extends AbstractController {

	private ComienzoJuegoView vista;

	public SeleccionEquiposController(ContenedorGlobal contenedorGlobal) {

		super(contenedorGlobal);
		this.vista = new ComienzoJuegoView();
	}


	@Override
	public void inicializar() {

		this.vista.onComenzarJuegoClick(e -> {
			
			CompraDeUnidadesController siguiente = new CompraDeUnidadesController(contenedorGlobal, this.vista.obtenerNombreJugador1(), this.vista.obtenerNombreJugador2());
			siguiente.inicializar();
		});

		this.renderizar(this.vista);
	}

}
