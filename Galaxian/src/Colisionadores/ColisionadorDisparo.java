package Colisionadores;

import Entidades.*;

public class ColisionadorDisparo extends Colision{
	Disparo disp;
	
	public ColisionadorDisparo(Disparo d) {
		disp=d;
	}
	
	public void afectarEnemigo(Enemigo e) {
		disp.golpearEnemigo(e);
	}
	
	public void afectarObstaculo(Obstaculo o) {
		disp.golpearEntidad(o);
	}
}
