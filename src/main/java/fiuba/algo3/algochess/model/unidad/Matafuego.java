package fiuba.algo3.algochess.model.unidad;

import java.util.ArrayList;

public class Matafuego {

    private ArrayList<Unidad> unidades;

    public Matafuego() {
        unidades = new ArrayList<Unidad>();
    }

    public void agregar(Unidad unidad) {
        unidades.add(unidad);
    }

    public void usar() {
        for (Unidad unidad : unidades) {
            unidad.cambiarEstadoNoQuemado();
        }
        unidades.clear();
    }
}
