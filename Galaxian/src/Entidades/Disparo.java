package Entidades;

public abstract class Disparo extends Entidad{
	int damage;
	
	public Disparo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		vida= 10;	
	}
	
	public void golpearJugador(Jugador j) {
		
	}
	
	public void golpearEnemigo(Enemigo enem) {
		
	}
		
}
