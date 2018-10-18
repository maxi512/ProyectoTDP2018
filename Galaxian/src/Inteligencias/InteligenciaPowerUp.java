package Inteligencias;

import Entidades.PowerUp;

public class InteligenciaPowerUp extends Inteligencia{
	private PowerUp p;
	
	public InteligenciaPowerUp(PowerUp p) {
		this.p=p;
	}
	
	public void mover() {
		p.mover(3);
	}
}
