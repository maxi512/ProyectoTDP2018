package Colisionadores;
import Entidades.*;

public class ColisionadorEnemigo extends Colision{
	private Enemigo enem;
	
	public ColisionadorEnemigo(Enemigo e) {
		enem= e;
	}
	
	public void afectarDisparo(Disparo disp) {
		disp.golpearEnemigo(enem);
	}
	
	public void afectarObstaculo(Obstaculo o) {
		enem.golpearObstaculo(o);
	}
	
}
