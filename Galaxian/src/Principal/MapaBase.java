package Principal;

import java.util.LinkedList;
import Entidades.*;
import PowerUps.*;

public class MapaBase extends Mapa {
	
	public MapaBase(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		int x= 50;
		int y= 50;
		
		for(int k=0;k<5;k++) {
			for(int i=0;i<5;i++){
				EnemigoBase enem= new EnemigoBase(7,x,y);
				enem.setJuego(j);
				enemigos.add(enem);
				x+= 70;
			}
			x=50;
			y+=70;
		}
		
		
		GeneradorPowerUp generador = new GeneradorPowerUp(j);
		for(Enemigo e: enemigos) {
			e.setPowerUpAlDestruir(generador.getPowerUpAleatorio());
		}
	}
		/**for(int i=0;i<2;i++){
			Enemigo enem= new EnemigoBase(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
	 	}**/
		
		/**PowerUp premio=new PowerUpArmaMejorada(7,250,250);
		premio.setJuego(j);
		obstaculos.add(premio);
		
		premio= new PowerUpEscudo(7,250,500);
		premio.setJuego(j);
		obstaculos.add(premio);*/
		
		
		/*EnemigoPierdeArma enem= new EnemigoPierdeArma(7,x,y);
		enem.setJuego(j);
		enemigos.add(enem);*/
		
		
		
		
		
		
		
		
		
		
		
		/*for(int i=0;i<5;i++){
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
		y+=100;
		x=100;
		for(int i=0;i<3;i++){
			EnemigoPierdeArma enem= new EnemigoPierdeArma(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			x+= 70;
		}
		
	 	obstaculos.add(new ObstaculoRompeJugador(250,300));
	 	obstaculos.add(new ObstaculoBasico(100,500));*/
	 	
		}
		
		
	

