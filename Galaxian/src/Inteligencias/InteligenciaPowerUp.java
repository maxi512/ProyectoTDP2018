package Inteligencias;

import PowerUps.PowerUp;

public class InteligenciaPowerUp extends Inteligencia{
	private PowerUp p;
	
	public InteligenciaPowerUp(PowerUp p) {
		this.p=p;
	}
	
	public void mover() {
		p.mover(3);
	}
}
