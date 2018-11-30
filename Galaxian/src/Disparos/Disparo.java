package Disparos;

import Entidades.*;

public abstract class Disparo extends Entidad{
	int damage;
	
	public Disparo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		vida= 10;
		vidaInicial= vida;
	}
	
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()<-5) {
			this.vida=-1;
		}
	}
	
	public abstract void golpearJugador(Jugador j) ;
	
	public abstract void golpearEnemigo(Enemigo enem) ;
		
	public abstract void golpearObstaculoEnemigoYJugador(Obstaculo o) ;
		
	public abstract void golpearObstaculoJugador(Obstaculo o);
}
