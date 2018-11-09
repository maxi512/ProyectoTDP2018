package Colisionadores;

import Disparos.Disparo;
import Entidades.*;

public class ColisionadorObstaculo extends Colision {
	
	private Obstaculo obstaculo;
	
	public ColisionadorObstaculo(Obstaculo o) {
		this.obstaculo=o;
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.quitarVida(100);
	}
	
	public void afectarDisparo(Disparo d) {
		d.golpearObstaculoEnemigoYJugador(obstaculo);
	}
}
