package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaNivel1 extends Mapa {
	
	public MapaNivel1(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		int x= 50;
		int y= 50;
		
		for(int k=0;k<4;k++) {
			EnemigoKamikaze enem= new EnemigoKamikaze(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			y+= 70;
		}
		
		y=50;
		x+=70;
		for(int i=0;i<3;i++) {
			for(int k=0;k<3;k++) {
				EnemigoBase enem= new EnemigoBase(7,x,y);
				enem.setJuego(j);
				enemigos.add(enem);
				y+= 70;
			}
			x+=70;
			y=50;
		}
		
		for(int k=0;k<2;k++) {
			EnemigoKamikazeMareado enem= new EnemigoKamikazeMareado(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			y+= 70;
		}
		
		for(int k=0;k<2;k++) {
			EnemigoPierdeArma enem= new EnemigoPierdeArma(7,x,y);
			enem.setJuego(j);
			enemigos.add(enem);
			y+= 70;
		}
		
		
		obstaculos.add(new ObstaculoRompeJugador(250,300));
	 	obstaculos.add(new ObstaculoBasico(100,500));
	 	obstaculos.add(new ObstaculoBasico(500,500));

	 	
	 	
		GeneradorPowerUp generador = new GeneradorPowerUp(j,4);
		for(Enemigo e: enemigos) {
			e.setPowerUpAlDestruir(generador.getPowerUpAleatorio());
		}
	}
}
		
		
	

