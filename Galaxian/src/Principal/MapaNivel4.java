package Principal;

import java.util.LinkedList;

import Entidades.*;

public class MapaNivel4 extends Mapa {
	public MapaNivel4(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		this.juego=j;
		int x= 50;
		int y= 50;
		
		for(int i=0;i<5;i++) {
			for(int k=0;k<3;k++) {
				EnemigoBase enem= new EnemigoBase(7,x,y);
				enem.setJuego(juego);
				enemigos.add(enem);
				y+= 70;
			}
			x+=70;
			y=50;
		}
		
		x=50;
		y=270;
		
		for(int k=0;k<5;k++) {
			EnemigoMareado enem= new EnemigoMareado(7,x,y);
			enem.setJuego(juego);
			enemigos.add(enem);
			x+= 70;
		}
		
		
		
		obstaculos.add(new ObstaculoBasico(100,400));
	 	obstaculos.add(new ObstaculoRompeJugador(200,400));
	 	obstaculos.add(new ObstaculoRompeJugador(300,400));
	 	obstaculos.add(new ObstaculoRompeJugador(400,400));
	 	obstaculos.add(new ObstaculoBasico(500,400));
	}
	
	public Mapa getSiguienteNivel() {
		return new MapaBoss(this.juego);
	}
}
