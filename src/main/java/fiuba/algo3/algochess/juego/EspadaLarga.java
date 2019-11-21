package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.unidad.Unidad;
import static fiuba.algo3.algochess.juego.ProveedorConstantes.DANIO_ARMA_SOLDADO;


public class EspadaLarga implements Arma {

	@Override
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException {
		unaUnidad.recibirDanio(DANIO_ARMA_SOLDADO);

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
