package Colisionadores;

import Disparos.Disparo;
import Entidades.*;
import Inteligencias.*;

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
	
	public void cambiarInteligencia(Inteligencia i) {
		enem.setInteligencia(i);
	}
	
}
