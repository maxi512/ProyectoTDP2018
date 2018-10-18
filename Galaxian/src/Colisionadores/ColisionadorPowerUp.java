package Colisionadores;

import Entidades.Disparo;
import Entidades.Enemigo;
import Entidades.Jugador;
import Entidades.Obstaculo;
import Entidades.PowerUp;

public class ColisionadorPowerUp extends Colision {
	
	private PowerUp pu;
	
	public ColisionadorPowerUp(PowerUp p) {
		pu=p;
	}
	
	
	public void afectarEnemigo(Enemigo e) {
		
	}
	
	public void afectarDisparo(Disparo d) {
		
	}
	
	public void afectarJugador(Jugador j) {
		pu.afectar();
	}
	
	public void afectarObstaculo(Obstaculo o) {
		
	}
}
