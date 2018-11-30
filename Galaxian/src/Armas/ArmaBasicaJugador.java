package Armas;

import Disparos.Disparo;
import Entidades.*;
import Disparos.DisparoJugador;

public class ArmaBasicaJugador extends Arma {
	
	
	public ArmaBasicaJugador(Jugador j) {
		super(j);
		this.tiempoHastaProximoDisparoDisponible=0;
		this.tiempoParaDisparar=10;
	}
	
	public Disparo generarDisparo(int x,int y) {
		DisparoJugador disp=null;
		if(tiempoHastaProximoDisparoDisponible<=0) {
			disp= new DisparoJugador(5,x,y);
			tiempoHastaProximoDisparoDisponible= tiempoParaDisparar;
		}
		return disp;
	}
	
	public void actualizar() {
		tiempoHastaProximoDisparoDisponible--;
	}
	
	
}
