package fiuba.algo3.algochess.modelo.juego;

import static fiuba.algo3.algochess.modelo.juego.ProveedorConstantes.DANIO_DISTANCIA_JINETE;

import fiuba.algo3.algochess.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

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
