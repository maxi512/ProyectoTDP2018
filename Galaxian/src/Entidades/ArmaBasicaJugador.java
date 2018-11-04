package Entidades;

public class ArmaBasicaJugador extends Arma {
	
	
	public ArmaBasicaJugador(Entidad e) {
		super(e);
	}
	
	public Disparo generarDisparo() {
		if(this.chequearCooldown()) {
			Disparo disp= new DisparoJugador(5,0,0);
			disp.getPos().setLocation((int)propietario.getPos().getX()+(propietario.getGrafico().getWidth()/2 -1), (int)propietario.getPos().getY()-12);
			return disp;
		}
			
		else return null;
	}
	
	
}
