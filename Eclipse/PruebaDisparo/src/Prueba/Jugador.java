package Prueba;

public class Jugador extends Entidad {
	protected int vida;
	
	public Jugador(int vel) {
		super(vel);
		vida=100;
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
	
	public int quitarVida(int puntos) {
		vida= vida-puntos;
		
		return vida;
	}
	
	public int getVida() {
		return vida;
	}
}
