package Armas;

import Disparos.Disparo;
import Disparos.DisparoMisil;
import Entidades.*;

public class ArmaMisil extends Arma {
	
	public ArmaMisil(Jugador j) {
		super(j);
		this.tiempoHastaProximoDisparoDisponible=0;
		this.tiempoParaDisparar=40;	
		this.cantBalas=10;
	}
	
	public Disparo generarDisparo(int x,int y) {
		DisparoMisil disp=null;
		if(tiempoHastaProximoDisparoDisponible<=0) {
			disp= new DisparoMisil(5,x,y);
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
