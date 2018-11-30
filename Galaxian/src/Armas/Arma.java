package Armas;

import Disparos.Disparo;
import Entidades.*;

public abstract class Arma {
	protected int tiempoParaDisparar;
	protected long tiempoHastaProximoDisparoDisponible;
	protected int cantBalas;
	protected Jugador propietario;
	
	public Arma(Jugador e) {
		propietario=e;
	}
	public Arma() {
		
	}
	
	public abstract Disparo generarDisparo(int x,int y);
	
	public void actualizar() {
		
	}
}
