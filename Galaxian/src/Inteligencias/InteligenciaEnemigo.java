package Inteligencias;

import Entidades.*;

public class InteligenciaEnemigo extends Inteligencia{
	
	private int movimientos;
	protected Enemigo enemigo;
	public InteligenciaEnemigo(Enemigo e) {
		movimientos=0;
		enemigo=e;
	}
	
	public void mover() {
		int dir=-1;
			if(movimientos>=0 && movimientos<20) {
				dir= 1;
				movimientos++;
			}
			else {
				if(movimientos>=20 && movimientos<40 ) {
					dir=0;
					movimientos++;
					if(movimientos==40) {
						movimientos=0;
					}
				}
			}
			enemigo.mover(dir);			
		}
	}

