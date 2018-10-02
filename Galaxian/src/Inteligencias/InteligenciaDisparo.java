package Inteligencias;

import Entidades.*;

public class InteligenciaDisparo extends Inteligencia{
	Disparo disp;
	
	public InteligenciaDisparo(Disparo d) {
		disp= d;
	}
	
	public void mover() {
		disp.mover(2);
	}
}
