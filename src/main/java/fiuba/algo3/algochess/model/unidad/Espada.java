package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_ARMA_JINETE;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public class Espada implements Arma {

	@Override
	public float ataqueCorto() throws AtaqueInvalidoException {
		//unaUnidad.recibirDanio(DANIO_ARMA_JINETE);
		return DANIO_ARMA_JINETE;
		
	}

	@Override
	public float ataqueMedio() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

	@Override
	public float ataqueLargo() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}
}
