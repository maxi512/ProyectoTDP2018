package Colisionadores;

import Entidades.*;
import PowerUps.*;
import Disparos.*;

public class ColisionadorPowerUp extends Colision {
	
	private PowerUp pu;
	
	public ColisionadorPowerUp(PowerUp p) {
		pu=p;
	}

	
	
	public void afectarEnemigo(Enemigo e) {
		
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		
	}
	
	public void afectarDisparoJugador(Disparo d){
	
	}
	
	public void afectarJugador(Jugador j) {
		pu.afectar();
	}
	
	public void afectarObstaculo(Obstaculo o) {
		
	}
	
	public void afectarPowerUp(PowerUp p) {
		
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		
	}

}
