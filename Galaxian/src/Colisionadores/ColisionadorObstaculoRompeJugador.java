package Colisionadores;

import Disparos.Disparo;
import Entidades.Enemigo;
import Entidades.Obstaculo;

public class ColisionadorObstaculoRompeJugador extends Colision {
	
	private Obstaculo obstaculo;
	
	public ColisionadorObstaculoRompeJugador(Obstaculo o) {
		this.obstaculo=o;
	}
	
	public void afectarEnemigo(Enemigo e) {
	}
	
	public void afectarDisparo(Disparo d) {
		
		d.golpearObstaculoJugador(obstaculo);
	}
}