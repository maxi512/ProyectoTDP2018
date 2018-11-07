package Colisionadores;

import Entidades.Jugador;
import PowerUps.PowerUp;

public class ColisionadorPowerUp extends Colision {
	
	private PowerUp pu;
	
	public ColisionadorPowerUp(PowerUp p) {
		pu=p;
	}

	public void afectarJugador(Jugador j) {
		pu.afectar();
	}
}
