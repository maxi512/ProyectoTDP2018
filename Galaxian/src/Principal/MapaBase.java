package Principal;

import java.util.LinkedList;
import Entidades.*;
import PowerUps.PowerUpArmaRapida;
import PowerUps.PowerUpEscudo;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		int x= 50;
		int y= 50;
		
		for(int i=0;i<3;i++){
			EnemigoPierdeArmaKamikaze enem= new EnemigoPierdeArmaKamikaze(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
		EnemigoKamikaze enem1= new EnemigoKamikaze(7,x,y);
		enem1.setJuego(j);
		enemigos.add(enem1);
		
		obstaculos.add(new PowerUpEscudo(7, 200, 350, j));
	 	obstaculos.add(new ObstaculoBasico(250,300));
		}
		
		
	}

