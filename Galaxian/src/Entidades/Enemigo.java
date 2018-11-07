package Entidades;

import Armas.Arma;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.Inteligencia;
import PowerUps.*;
import Principal.Juego;

public abstract class Enemigo extends Entidad {
	protected Juego juego;
	private PowerUp powerUpAlDestruir;
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		juego=null;
		
		vidaInicial=100;
	}
	//METODOS PROVISORIOS
	
	public Juego getJuego() {
		return juego;
	}
	
	public void setPowerUpAlDestruir(PowerUp p) {
		powerUpAlDestruir=p;
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
	
	public void destruir() {
		if(powerUpAlDestruir!=null) {
			powerUpAlDestruir.getPos().setLocation(this.pos.x, this.pos.y);
			juego.addEntidad(powerUpAlDestruir);
		}
		
	}
	
}
