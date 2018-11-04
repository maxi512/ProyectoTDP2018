package Armas;

import Disparos.Disparo;
import Disparos.DisparoMisil;
import Entidades.Jugador;

public class ArmaMisil extends Arma {
	
	
	public ArmaMisil(Jugador j) {
		super(j);
		this.setTiempoDisparo(35);

	}
	
	public Disparo generarDisparo() {
		if(this.chequearCooldown()) {
			Disparo disp= new DisparoMisil(5,0,0);
			disp.getPos().setLocation((int)propietario.getPos().getX()+(propietario.getGrafico().getWidth()/2 -1), (int)propietario.getPos().getY()-12);
			return disp;
		}
			
		else return null;
	}

}
