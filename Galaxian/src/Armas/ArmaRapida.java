package Armas;

import Disparos.Disparo;
import Disparos.DisparoRapido;
import Entidades.Jugador;

public class ArmaRapida extends Arma {

	public ArmaRapida(Jugador j) {
		super(j);
		this.setTiempoDisparo(5);
	}
	
	public Disparo generarDisparo() {
		if(this.chequearCooldown()) {
			Disparo disp= new DisparoRapido(5,0,0);
			disp.getPos().setLocation((int)propietario.getPos().getX()+(propietario.getGrafico().getWidth()/2 -1), (int)propietario.getPos().getY()-12);
			return disp;
		}
			
		else return null;
	}
	
	
}
