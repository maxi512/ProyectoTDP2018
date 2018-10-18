package Entidades;

public class ArmaBasicaJugador extends Arma {
	
	
	public ArmaBasicaJugador() {
	}
	
	public Disparo generarDisparo() {
		//POS DEFAULT EL JUGADOR TIENE QUE PONER SU POSICION
		return new DisparoJugador(5,0,0);
	}
	
	
}
