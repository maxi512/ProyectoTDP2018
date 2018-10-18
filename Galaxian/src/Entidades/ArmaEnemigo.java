package Entidades;

public class ArmaEnemigo extends Arma {
	public ArmaEnemigo() {
		
	}
	
	public Disparo generarDisparo() {
		return new DisparoEnemigo(5,0,0);
	}
}
