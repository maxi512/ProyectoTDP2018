package Colisionadores;
import Entidades.*;

public class ColisionadorEnemigo extends Colision{
	private Enemigo enem;
	
	public ColisionadorEnemigo(Enemigo e) {
		enem= e;
	}
	
	public void afectarDisparo(Disparo disp) {
		enem.quitarVida(disp.getDamage());
		disp.quitarVida(disp.getVida());
	}
	
	public void afectarObstaculo(Obstaculo o) {
		/////PREGUNTAR COLISION///
		enem.quitarVida(100);
		o.quitarVida(20);
	}
	
}
