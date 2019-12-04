package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_ARMA_SOLDADO;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;


public class EspadaLarga implements Arma {

	@Override
	public float ataqueCorto() throws AtaqueInvalidoException {
		//unaUnidad.recibirDanio(DANIO_ARMA_SOLDADO);
		return DANIO_ARMA_SOLDADO;

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
