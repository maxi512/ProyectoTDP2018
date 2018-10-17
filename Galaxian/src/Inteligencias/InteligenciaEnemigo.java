package Inteligencias;

import Entidades.*;

public class InteligenciaEnemigo extends Inteligencia{
	protected Enemigo enemigo;
	public InteligenciaEnemigo(Enemigo e) {
		enemigo=e;
	}
	
	public void mover() {
		int dir=-1;
		if(enemigo.getJuego().moverDerecha()){
			dir=1;
		}
		else {
			dir=0;
		}
		enemigo.mover(dir);
		if(enemigo.getPos().getX()+ enemigo.getGrafico().getWidth() >= enemigo.getJuego().getAnchoGui()-20) {
			if(!enemigo.getJuego().cambioDireccion()) {
				enemigo.getJuego().setCambiarDireccion(true);
			}
		}
		else {
			if(enemigo.getPos().getX()-15 <= 10) {
				if(enemigo.getJuego().cambioDireccion()) {
					enemigo.getJuego().setCambiarDireccion(false);
				}
			}
		}
		
	}
}

