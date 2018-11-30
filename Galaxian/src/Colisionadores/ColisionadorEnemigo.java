package Colisionadores;

import Disparos.Disparo;
import Entidades.*;
import PowerUps.PowerUp;

public class ColisionadorEnemigo extends Colision{
	private Enemigo enem;
	
	public ColisionadorEnemigo(Enemigo e) {
		enem= e;
	}
	
	public void afectarEnemigo(Enemigo e) {
		
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		
	}
	
	public void afectarDisparoJugador(Disparo d){
		d.golpearEnemigo(enem);
	}
	
	public void afectarJugador(Jugador j) {
		enem.golpearJugador(j);
	}
	
	public void afectarObstaculo(Obstaculo o) {
		enem.golpearObstaculo(o);
	}
	
	public void afectarPowerUp(PowerUp p) {
		
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		
	}
	

	
}
