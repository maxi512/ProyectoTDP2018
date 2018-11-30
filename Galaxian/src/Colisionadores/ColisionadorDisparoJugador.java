package Colisionadores;

import Disparos.*;
import Entidades.*;
import PowerUps.*;

public class ColisionadorDisparoJugador extends Colision {
	
Disparo disp;
	
	public ColisionadorDisparoJugador(Disparo d) {
		disp=d;
	}
	
	
	public void afectarEnemigo(Enemigo e) {
		disp.golpearEnemigo(e);
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		
	}
	
	public void afectarDisparoJugador(Disparo d){
	
	}
	
	public void afectarJugador(Jugador j) {
		
	}
	
	public void afectarObstaculo(Obstaculo o) {
		disp.golpearObstaculoEnemigoYJugador(o);
	}
	
	public void afectarPowerUp(PowerUp p) {
		
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		disp.golpearObstaculoJugador(o);
	}
}
