package fiuba.algo3.algochess.modelo.juego;

import fiuba.algo3.algochess.modelo.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.modelo.unidad.Unidad;

public interface Arma {


	
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException;

		
}
