package Colisionadores;

import Disparos.*;
import Entidades.*;
import PowerUps.*;

public class ColisionadorObstaculo extends Colision {
	
	private Obstaculo obstaculo;
	
	public ColisionadorObstaculo(Obstaculo o) {
		this.obstaculo=o;
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.golpearObstaculo(obstaculo);
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		d.golpearObstaculoEnemigoYJugador(obstaculo);
	}
	
	public void afectarDisparoJugador(Disparo d){
		d.golpearObstaculoEnemigoYJugador(obstaculo);
	}
	
	public void afectarJugador(Jugador j) {
		
	}
	
	public void afectarObstaculo(Obstaculo o) {
		
	}
	
	public void afectarPowerUp(PowerUp p) {
		
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		
	}

}
