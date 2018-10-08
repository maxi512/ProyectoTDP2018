package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Obstaculo>();
		int x= 20;
		int y= 110;
		
		for(int i=0;i<1;i++){
			enemigos.add(new EnemigoKamikaze(7,x,y,j));
			x+=100;
		}
		
		obstaculos.add(new ObstaculoBasico (x,y));
	}
}
