package Entidades;

public class ArmaMisil extends Arma {
	
	public ArmaMisil(Jugador j) {
		j.setTiempoDisparo(35);

	}
	public Disparo generarDisparo() {
		return new DisparoMisil(5,0,0);
	}

}
