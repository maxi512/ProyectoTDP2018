package Prueba;

public abstract class Entidad {
	protected int velocidad;
	
	protected Entidad(int velocidad) {
		this.velocidad= velocidad;
	}
	
	public abstract void serColisionado(Colision col);
}
