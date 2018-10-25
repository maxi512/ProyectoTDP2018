package Colisionadores;

import Entidades.*;

public class ColisionadorObstaculo extends Colision {
	
	private Obstaculo obstaculo;
	
	public ColisionadorObstaculo(Obstaculo o) {
		this.obstaculo=o;
	}
	
	public void afectarEnemigo(Enemigo e) {
		e.quitarVida(100);
		System.out.println("Colisionaron");
	}
	
	public void afectarDisparo(Disparo d) {
		d.quitarVida(100);
		obstaculo.quitarVida(20);
		d.golpearObstaculoEnemigoYJugador(obstaculo);
	}
	

}
