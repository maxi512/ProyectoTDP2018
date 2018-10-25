package Entidades;

public abstract class Disparo extends Entidad{
	int damage;
	
	public Disparo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		vida= 10;	
	}
	
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()<-5) {
			this.vida=-1;
		}
	}
	
	public void golpearJugador(Jugador j) {
		
	}
	
	public void golpearEnemigo(Enemigo enem) {
		
	}
	public void golpearObstaculoEnemigoYJugador(Obstaculo o) {
		
	}
	public void golpearObstaculoJugador(Obstaculo o) {
		
	}	
}
