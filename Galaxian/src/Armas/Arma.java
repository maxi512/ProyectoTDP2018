package Armas;

import Disparos.Disparo;
import Entidades.Entidad;

public abstract class Arma {
	
	protected int SHOOT_COOLDOWN_UPDATE_TIME = 10;
	protected long timeUntilShootingAvailable = 0;
	
	protected Entidad propietario;
	
	public Arma(Entidad e) {
		propietario=e;
	}
	
	public abstract Disparo generarDisparo();
	
	public void Update() {
        timeUntilShootingAvailable = timeUntilShootingAvailable - 1;
	}
	
	protected void setTiempoDisparo(int tiempo) {
		SHOOT_COOLDOWN_UPDATE_TIME=tiempo;
	}
	
	protected boolean chequearCooldown() {
		boolean toReturn;
		if(timeUntilShootingAvailable <=0) {
			timeUntilShootingAvailable= SHOOT_COOLDOWN_UPDATE_TIME;
			toReturn=true;
		}
		else {
			toReturn= false;
		}
		return toReturn;
	}
}
