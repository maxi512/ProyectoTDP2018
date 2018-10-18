package Colisionadores;
import Entidades.*;

public class ColisionadorJugador extends Colision{
	public Jugador jug;
	
	public ColisionadorJugador(Jugador j) {
		jug= j;
	}
	
	public void afectarDisparo(Disparo d) {
		d.golpearJugador(jug);
	}
	
	public void afectarEnemigo(Enemigo enem) {
		enem.golpearJugador(jug);
	}
	
	public void afectarPowerUp(PowerUp p) {
		p.afectar();
	}
}
