package Colisionadores;

import Disparos.*;
import Entidades.*;
import PowerUps.*;

public class ColisionadorJugador extends Colision{
	public Jugador jug;
	
	public ColisionadorJugador(Jugador j) {
		jug= j;
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.golpearJugador(jug);
	}
	
	public void afectarDisparoEnemigo(Disparo d) {
		d.golpearJugador(jug);
	}
	
	public void afectarDisparoJugador(Disparo d){
	
	}
	
	public void afectarJugador(Jugador j) {
		
	}
	
	public void afectarObstaculo(Obstaculo o) {
		
	}
	
	public void afectarPowerUp(PowerUp p) {
		p.afectar();
	}
	
	public void afectarObstaculoRompeJugador(Obstaculo o) {
		
	}
}
