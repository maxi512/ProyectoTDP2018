package Principal;

public class InteligenciaEnemigo extends Inteligencia{
	
	private int movimientos;
	private Enemigo enemigo;
	public InteligenciaEnemigo(Enemigo e) {
		movimientos=0;
		enemigo=e;
	}
	
	public void mover() {
		int dir=-1;
			if(movimientos>=0 && movimientos<39) {
				dir= 1;
				movimientos++;
			}
			else {
				if(movimientos>=39 && movimientos< 78) {
					dir=0;
					movimientos++;
					if(movimientos==78) {
						movimientos=0;
					}
				}
			}
			enemigo.mover(dir);			
		}
	}

