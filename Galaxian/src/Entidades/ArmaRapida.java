package Entidades;

public class ArmaRapida extends Arma {

	public ArmaRapida(Jugador j) {
		j.setTiempoDisparo(5);
	}
	
	public Disparo generarDisparo() {
		return new DisparoRapido(5,0,0);
	}
	
	
}
