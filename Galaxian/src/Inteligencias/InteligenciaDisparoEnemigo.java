package Inteligencias;

import Entidades.DisparoEnemigo;

public class InteligenciaDisparoEnemigo extends Inteligencia {
	DisparoEnemigo disp;
	
	public InteligenciaDisparoEnemigo(DisparoEnemigo disp) {
		this.disp= disp;
	}
	

	public void mover() {
		disp.mover(3);
	}

}
