package Colisionadores;

import Disparos.*;
import Entidades.*;
import PowerUps.*;

public class ColisionadorDisparoEnemigo extends Colision{
	Disparo disp;
	
	public ColisionadorDisparoEnemigo(Disparo d) {
		disp=d;
	}
	
	public void afectarEnemigo(Enemigo e) {
		
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		
	}
	
	public void afectarDisparoJugador(Disparo d){
	
	}
	
	
	public void afectarJugador(Jugador j) {
		disp.golpearJugador(j);
	}
	
	public void afectarObstaculo(Obstaculo o) {
		disp.golpearObstaculoEnemigoYJugador(o);
	}
	
	public void afectarPowerUp(PowerUp p) {
		
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		
	}
}
