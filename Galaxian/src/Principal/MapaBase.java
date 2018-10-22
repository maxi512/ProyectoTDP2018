package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		int x= 50;
		int y= 50;
		
		obstaculos.add(new PowerUpArmaMejorada(7,300,200,j));
	 	for(int i=0;i<5;i++){
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
	 	
	 	x= 300;
	 	y= 300;
	 	
	 	obstaculos.add(new ObstaculoBasico(x,y));

	 	
	}
}
