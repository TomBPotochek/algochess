package fiuba.algo3.algochess.model.unidad;

import fiuba.algo3.algochess.model.excepciones.AtaqueInvalidoException;

public interface Arma {


	
	public float ataqueCorto() throws AtaqueInvalidoException;

	
	public float ataqueMedio() throws AtaqueInvalidoException;

	
	public float ataqueLargo() throws AtaqueInvalidoException;

		
}
