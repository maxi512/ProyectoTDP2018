package Entidades;

import Principal.Juego;

public abstract class PowerUp extends Entidad {
	
	protected Juego juego;
	
	public PowerUp(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y);
		juego=j;
	}
	
	 public abstract void afectar();
}
