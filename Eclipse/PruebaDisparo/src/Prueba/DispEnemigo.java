package Prueba;

public class DispEnemigo extends Disparo{
	protected int danio;
	public DispEnemigo(int velocidad, int d) {
		super(velocidad);
		danio=d;
	}
	
	public void colisionar(Entidad e) {
		ColisionarDisparoEnemigo col= new ColisionarDisparoEnemigo(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision c) { 
		
	}
	
	public void golpearJugador(Jugador jug) {
		jug.quitarVida(danio);
	}
}
