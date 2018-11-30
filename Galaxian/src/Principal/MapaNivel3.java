package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaNivel3 extends Mapa {
	
	public MapaNivel3(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		this.juego= j;
		int x= 50;
		int y= 50;
		
		for (int i=0;i<5;i++) {
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(juego);
			enemigos.add(enem);
			x+= 70;
		}
		x=50;
		y+=50;
		
		for (int i=0;i<5;i++) {
			EnemigoBase enem= new EnemigoBase(7,x,y);
			enem.setJuego(juego);
			enemigos.add(enem);
			x+= 70;
		}
		
		x=100;
	 	y+=50;

		
		obstaculos.add(new ObstaculoBasico(100,200));
	 	obstaculos.add(new ObstaculoBasico(200,200));
	 	obstaculos.add(new ObstaculoBasico(300,200));
	 	obstaculos.add(new ObstaculoBasico(400,200));
	 	obstaculos.add(new ObstaculoBasico(500,200));
	 	
	 	y=250;
	 	for (int i=0;i<3;i++) {
			EnemigoPierdeArmaKamikaze enem= new EnemigoPierdeArmaKamikaze(7,x,y);
			enem.setJuego(juego);
			enemigos.add(enem);
			x+= 70;
		}
	 	
	 	x=150;
	 	y+=50;
	 	
	 	
	 	for (int i=0;i<3;i++) {
			EnemigoMareado enem= new EnemigoMareado(7,x,y);
			enem.setJuego(juego);
			enemigos.add(enem);
			x+= 70;
		}
	 	

	 	obstaculos.add(new ObstaculoRompeJugador(300,400));
	 	obstaculos.add(new ObstaculoRompeJugador(400,400));
	 	
	 	
	 	
		GeneradorPowerUp generador = new GeneradorPowerUp(juego,6);
		for(Enemigo e: enemigos) {
			e.setPowerUpAlDestruir(generador.getPowerUpAleatorio());
		}
	}
	
	public Mapa getSiguienteNivel() {
		return new MapaNivel4(juego);
	}
}
