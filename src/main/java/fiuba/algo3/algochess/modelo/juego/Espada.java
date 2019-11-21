package fiuba.algo3.algochess.modelo.juego;

import static fiuba.algo3.algochess.modelo.juego.ProveedorConstantes.DANIO_ARMA_JINETE;

import fiuba.algo3.algochess.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

public class Espada implements Arma {

	@Override
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException {
		unaUnidad.recibirDanio(DANIO_ARMA_JINETE);
		
	}

	@Override
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

	@Override
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

	

}
