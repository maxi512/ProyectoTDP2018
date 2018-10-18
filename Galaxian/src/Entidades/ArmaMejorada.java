package Entidades;

public class ArmaMejorada extends Arma {
	public ArmaMejorada() {
	}
	
	public Disparo generarDisparo() {
		//POS DEFAULT EL JUGADOR TIENE QUE PONER SU POSICION
		return new DisparoMejorado(5,0,0);
	}
}
