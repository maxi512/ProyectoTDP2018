package Prueba;

public class ColisionarDisparoEnemigo extends Colision {
	private DispEnemigo disp;
	
	public ColisionarDisparoEnemigo(DispEnemigo d) {
		disp=d;
	}
	
	public void afectarJugador(Jugador jug) {
		disp.golpearJugador(jug);
	}

}
