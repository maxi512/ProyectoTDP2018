package PowerUps;

import Entidades.Entidad;
import Principal.Juego;

public abstract class PowerUp extends Entidad {
	
	protected Juego juego;
	
	public PowerUp(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.vida=100;
	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	
	public abstract void afectar();
	 
	public Juego getJuego() {
			return juego;
		}
		
	public void setJuego(Juego j) {
			juego=j;
	}
}
