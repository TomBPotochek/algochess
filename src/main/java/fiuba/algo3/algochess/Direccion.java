package fiuba.algo3.algochess;

import fiuba.algo3.algochess.juego.Posicion;

public enum Direccion {
	N(0,1),
	NE(1,1),
	E(1,0),
	SE(1,-1),
	S(0,-1),
	SO(-1,-1),
	O(-1,0),
	NO(-1,1);
	
	static {
		N.direccionOpuesta = S;
		NE.direccionOpuesta = SO;
		E.direccionOpuesta = O;
		SE.direccionOpuesta = NO;
		S.direccionOpuesta = N;
		SO.direccionOpuesta = NE;
		O.direccionOpuesta = E;
		NO.direccionOpuesta = SE;
	}
	
	private Direccion direccionOpuesta;
	private int dx;
	private int dy;
	Direccion(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public Posicion calcularPosicionSiguiente(Posicion posicion) {
		int x = posicion.obtenerCoordenadaX();
		int y = posicion.obtenerCoordenadaY();
		x += this.dx;
		y += this.dy;
		return new Posicion(x,y);
	}
	
	public Direccion direccionOpuesta() {
		
		return direccionOpuesta; 
	}
}