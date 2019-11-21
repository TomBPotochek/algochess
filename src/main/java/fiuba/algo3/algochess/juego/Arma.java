package fiuba.algo3.algochess.juego;

import fiuba.algo3.algochess.excepciones.AtaqueInvalidoException;
import fiuba.algo3.algochess.unidad.Atacante;
import fiuba.algo3.algochess.unidad.Unidad;

public interface Arma {


	
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException;

		
}
