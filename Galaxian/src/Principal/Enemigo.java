package Principal;


public abstract class Enemigo extends Entidad {
	protected int movidas;
	
	public Enemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		this.vida=100;
		
		movidas=0;
	}
	
	public void ajustarMovimientos(int mov) {
		movidas= mov;
	}
	
	public int getCantMovimientos() {
		return movidas;
	}
}
