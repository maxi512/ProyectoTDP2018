package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Obstaculo>();
		int x= 0;
		int y= 50;
		
	 	/*for(int i=0;i<5;i++){
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 100;
			y+=50;
			
		}*/
		x=0;
		/*for(int p=0;p<3;p++) {
			EnemigoKamikaze enemigo= new EnemigoKamikaze(9,x,y);
			enemigo.setJuego(j);
			enemigos.add(enemigo);
			x+= 70;
		}*/
		
		
		
		
		//obstaculos.add(new ObstaculoBasico (x,y));
	}
}
