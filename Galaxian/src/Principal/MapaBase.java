package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Obstaculo>();
		int x= 20;
		int y= 110;
		for(int i=0;i<5;i++){
			enemigos.add(new EnemigoBase(5,x,y));
			x+=100;
		}
		
		enemigos.add(new EnemigoKamikaze (10,x,y,j));
		/*for (int i=0;i<3;i++) {
			y+=40;
			enemigos.add(new OtroEnemigo(5,x,y));
		}*/
	}
}
