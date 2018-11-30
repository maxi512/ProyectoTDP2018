package Colisionadores;

import Disparos.*;
import Entidades.*;
import PowerUps.PowerUp;

public abstract class Colision {
	public abstract void afectarEnemigo(Enemigo e);
	
	public abstract void afectarDisparoEnemigo(Disparo d);
	
	public abstract void afectarDisparoJugador(Disparo d);
	
	public abstract void afectarJugador(Jugador j);
	
	public abstract void afectarObstaculo(Obstaculo o);
	
	public abstract void afectarPowerUp(PowerUp p);
	
	public abstract void afectarObstaculoRompeJugador(Obstaculo o);
}