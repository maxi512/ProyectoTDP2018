package Entidades;

import Principal.Juego;

public abstract class Enemigo extends Entidad {
	protected Juego juego;
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		juego=null;
	}
	public Enemigo(int velocidad,int x,int y, Juego j) {
		super(velocidad,x,y);
		juego=j;
	}
	//METODOS PROVISORIOS
	
	public Juego getJuego() {
		return juego;
	}
	
	public void setJuego(Juego j) {
		juego=j;
	}
	
	public void golpearObstaculo(Obstaculo o) {
		
	}
	
	public void golpearJugador(Jugador j) {
		
	}
}
