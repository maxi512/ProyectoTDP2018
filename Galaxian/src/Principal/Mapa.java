package Principal;

import java.util.LinkedList;

public abstract class Mapa {
	protected LinkedList<Enemigo> enemigos;
	protected LinkedList<Obstaculo> obstaculos;
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}
}
