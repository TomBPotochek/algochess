package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.model.juego.AlgoChess;
import fiuba.algo3.algochess.model.tablero.Direccion;
import fiuba.algo3.algochess.view.BatallaView;
import fiuba.algo3.algochess.view.ContenedorGlobal;

public class BatallaController extends AbstractController {

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

		vista.onMoverNorteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.N));
		vista.onMoverNorEsteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.NE));
		vista.onMoverEsteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.E));
		vista.onMoverSurEsteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.SE));
		vista.onMoverSurClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.S));
		vista.onMoverSurOesteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.SO));
		vista.onMoverOesteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.O));
		vista.onMoverNorOesteClick(new MoverUnidadEventHandler(algoChess.getTurnoActual(), vista, Direccion.NO));


		this.renderizar(this.vista);
	}

}
