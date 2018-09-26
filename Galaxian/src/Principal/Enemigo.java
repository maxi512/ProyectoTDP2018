package Principal;


public abstract class Enemigo extends Entidad {
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		this.vida=100;
	}
}
