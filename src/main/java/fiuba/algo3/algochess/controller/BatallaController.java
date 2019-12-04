package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.view.BatallaView;
import fiuba.algo3.algochess.view.ContenedorGlobal;

public class BatallaController extends AbstractController{

	private BatallaView vista;
	private AlgoChess algoChess;
	

	public BatallaController(ContenedorGlobal contenedorGlobal, AlgoChess algoChess) {

		// TODO : mandar controller final
		super(contenedorGlobal);
		this.vista = new BatallaView(algoChess);
		this.algoChess = algoChess;
	}

	@Override
	public void inicializar() {
		// TODO Auto-generated method stub

		vista.onUnidadClick(new UnidadClickEventHandler(vista, algoChess.getTurnoActual()));
		this.renderizar(this.vista);
		vista.deshabilitarControles();
	}
}