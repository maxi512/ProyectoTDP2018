package Inteligencias;
import Principal.*;
import java.awt.*;

import Entidades.Enemigo;
public class InteligenciaKamikaze extends InteligenciaEnemigo {
	
	private Juego juego;
	
	//A DISCUTIR: O EL MAPA CONOCE AL JUEGO Y EL ENEMIGO/INTELIGENCIA AL MAPA, Y EL MAPA AL JUEGO   O   INTELIGENCIA/ENEMIGO CONOCE AL JUEGO  
	public InteligenciaKamikaze(Enemigo e, Juego j) {
		super(e);
		juego=j;
	}
	
	public void mover() {
		Point posJ = juego.getPosJugador();
		if(this.enemigo.getPos().getX()>posJ.getX()) {
			this.enemigo.mover(0);
			this.enemigo.mover(3);
		}
		else {
			if(this.enemigo.getPos().getX()<posJ.getX()) {
				this.enemigo.mover(1);
				this.enemigo.mover(3);
			}
			else {
				this.enemigo.mover(3);
			}
		}
		
	}
}
