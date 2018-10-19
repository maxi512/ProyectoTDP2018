package Entidades;

import Colisionadores.ColisionadorEnemigo;
import Inteligencias.Inteligencia;
import Principal.Juego;

public abstract class Enemigo extends Entidad {
	protected Juego juego;
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		juego=null;
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
	
	public void serDetenido(Inteligencia i) {
		ColisionadorEnemigo col= new ColisionadorEnemigo(this);
		col.cambiarInteligencia(i);
	}
	
	public Arma getArma() {
		return null;
	}
	
}
