package Entidades;

import Principal.Juego;

public abstract class PowerUp extends Entidad {
	
	protected Juego juego;
	
	public PowerUp(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y);
		juego=j;
	}
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	 public abstract void afectar();
}
