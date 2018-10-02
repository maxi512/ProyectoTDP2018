package Entidades;
import Colisionadores.*;

public abstract class Enemigo extends Entidad {
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
	}
	
	
	//METODOS PROVISORIOS
	public abstract void colisionar(Entidad e);
	
	public abstract void serColisionado(Colision col);
}
