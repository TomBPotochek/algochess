package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_ARMA_JINETE;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

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
