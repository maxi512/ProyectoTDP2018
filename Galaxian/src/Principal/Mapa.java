package Principal;

import java.util.LinkedList;
import Entidades.*;

public abstract class Mapa {
	protected LinkedList<Enemigo> enemigos;
	protected LinkedList<Obstaculo> obstaculos;
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public LinkedList<Obstaculo> getObstaculos() {
		return obstaculos;
	}
}
