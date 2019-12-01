package fiuba.algo3.algochess.controller;

import fiuba.algo3.algochess.view.AbstractView;
import fiuba.algo3.algochess.view.ContenedorGlobal;

public abstract class AbstractController {

	protected ContenedorGlobal contenedorGlobal;
	
	public AbstractController(ContenedorGlobal contenedorGlobal) {
		
		this.contenedorGlobal = contenedorGlobal;

	}
	
	protected void renderizar(AbstractView vista) {

		contenedorGlobal.cambiarEscena(vista.dibujar());
	}
	
	public abstract void inicializar();
}
