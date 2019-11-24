package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_DISTANCIA_JINETE;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public class ArcoYFlecha implements Arma {

	@Override
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

	@Override
	public void ataqueMedio(Unidad unaUnidad) {
		unaUnidad.recibirDanio(DANIO_DISTANCIA_JINETE);
		
	}

	@Override
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
		
	}

}
