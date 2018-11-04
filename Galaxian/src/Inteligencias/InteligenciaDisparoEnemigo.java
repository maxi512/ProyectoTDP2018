package Inteligencias;

import Disparos.DisparoEnemigo;

public class InteligenciaDisparoEnemigo extends Inteligencia {
	DisparoEnemigo disp;
	
	public InteligenciaDisparoEnemigo(DisparoEnemigo disp) {
		this.disp= disp;
	}
	

	public void mover() {
		disp.mover(3);
	}

}
