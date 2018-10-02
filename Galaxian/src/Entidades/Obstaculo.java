package Entidades;

public abstract class Obstaculo extends Entidad {
	public Obstaculo(int x, int y) {
		super(0,x,y);
		this.vida=100;
	}
}
