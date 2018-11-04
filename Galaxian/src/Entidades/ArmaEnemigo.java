package Entidades;

public class ArmaEnemigo extends Arma {
	public ArmaEnemigo(Enemigo e) {
		super(e);	
	}
	
	public Disparo generarDisparo() {
		Disparo disp = new DisparoEnemigo(5,0,0);
		disp.getPos().setLocation((int)this.propietario.getPos().getX()+(this.propietario.getGrafico().getWidth()/2 -1), (int)this.propietario.getPos().getY()+30);
		return disp;
	}
}
