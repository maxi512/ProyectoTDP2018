package Prueba;

public abstract class Disparo  extends Entidad{
	public Disparo(int velocidad) {
		super(velocidad);
	}
	
	public abstract void colisionar(Entidad e);
}
