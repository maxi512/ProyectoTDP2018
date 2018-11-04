package Entidades;

public class ArmaMejorada extends Arma {
	public ArmaMejorada(Jugador j) {
		super(j);
	}
	
	public Disparo generarDisparo() {
		if(this.chequearCooldown()) {
			Disparo disp= new DisparoMejorado(5,0,0);
			disp.getPos().setLocation((int)propietario.getPos().getX()+(propietario.getGrafico().getWidth()/2 -1), (int)propietario.getPos().getY()-12);
			return disp;
		}
			
		else return null;
	}
}
