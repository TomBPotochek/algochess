package fiuba.algo3.algochess.model.unidad;

import static fiuba.algo3.algochess.model.juego.ProveedorConstantes.DANIO_DISTANCIA_CATAPULTA;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;


public class Piedra implements Arma {

	@Override
	public float ataqueCorto() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public float ataqueMedio() throws AtaqueInvalidoException {
		throw new AtaqueInvalidoException();
	}

	@Override
	public float ataqueLargo() {
//		unaUnidad.quemar();
//		unaUnidad.recibirDanio(DANIO_DISTANCIA_CATAPULTA);
		//esto no contempla el danio recursivo de catapulta
		return DANIO_DISTANCIA_CATAPULTA;
	}

}
