package Principal;

import java.util.LinkedList;

public class MapaBase extends Mapa {
	
	public MapaBase() {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Obstaculo>();
		int x= 20;
		int y= 40;
		for(int i=0;i<5;i++){
			enemigos.add(new EnemigoBase(5,x,y));
			x+=30;
			y+=30;
		}
		for (int i=0;i<3;i++) {
			y+=40;
			enemigos.add(new OtroEnemigo(5,x,y));
		}
	}
}
