package Armas;

import Disparos.Disparo;
import Disparos.DisparoEnemigo;

public class ArmaEnemigo extends Arma {
	public ArmaEnemigo() {
		super();	
	}
	
	public Disparo generarDisparo(int x,int y) {
		return new DisparoEnemigo(5,x,y);
	}
}
