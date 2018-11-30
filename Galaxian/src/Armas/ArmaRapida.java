package Armas;

import Disparos.Disparo;
import Disparos.DisparoRapido;
import Entidades.*;

public class ArmaRapida extends Arma {

	public ArmaRapida(Jugador j) {
		super(j);
		this.tiempoHastaProximoDisparoDisponible=0;
		this.tiempoParaDisparar=7;
		this.cantBalas=80;
	}
	
	public Disparo generarDisparo(int x,int y) {
		DisparoRapido disp=null;
		if(tiempoHastaProximoDisparoDisponible<=0) {
			disp= new DisparoRapido(5,x,y);
			tiempoHastaProximoDisparoDisponible= tiempoParaDisparar;
			cantBalas--;
		}
		if(cantBalas==0) {
			propietario.setArma(new ArmaBasicaJugador(propietario));
		}
		return disp;
	}
	
	public void actualizar() {
		tiempoHastaProximoDisparoDisponible--;
	}
	
	
}
