package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.unidad.Unidad;
import static fiuba.algo3.algochess.juego.ProveedorConstantes.DANIO_DISTANCIA_CATAPULTA;


public class Piedra implements Arma {

	@Override
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public void ataqueLargo(Unidad unaUnidad) {
		unaUnidad.recibirDanio(DANIO_DISTANCIA_CATAPULTA);
		//esto no contempla el danio recursivo de catapulta

	}

}
