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
	
}
