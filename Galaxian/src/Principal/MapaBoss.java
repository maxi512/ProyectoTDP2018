package Principal;

import java.util.LinkedList;
import Entidades.*;

public class MapaBoss extends Mapa {
	public MapaBoss(Juego j) {
		this.enemigos= new LinkedList<Enemigo>();
		this.obstaculos= new LinkedList<Entidad>();
		this.juego=j;
		int x=270;
		int y=270;
		
		Enemigo enem= new PrimerBoss(10,x,y);
		enem.setJuego(juego);
		enemigos.add(enem);
	}
	
	public Mapa getSiguienteNivel() {
		return null;
	}
	
}
