package Armas;

import Disparos.Disparo;
import Disparos.DisparoEnemigo;

public class ArmaEnemigo extends Arma {
	public ArmaEnemigo() {
		super();	
	}
	
	public Disparo generarDisparo() {
		return new DisparoEnemigo(5,0,0);
	}
}
