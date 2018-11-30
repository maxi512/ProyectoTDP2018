package Principal;

import java.util.LinkedList;
import Entidades.*;

public abstract class Mapa {
	protected LinkedList<Enemigo> enemigos;
	protected LinkedList<Entidad> obstaculos;
	protected Juego juego;
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public LinkedList<Entidad> getObstaculos() {
		return obstaculos;
	}
	
	public abstract Mapa getSiguienteNivel();
	
	
}
