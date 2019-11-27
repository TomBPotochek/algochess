package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public interface Arma {


	
	public void ataqueCorto(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueMedio(Unidad unaUnidad) throws AtaqueInvalidoException;

	
	public void ataqueLargo(Unidad unaUnidad) throws AtaqueInvalidoException;

		
}
