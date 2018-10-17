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
		int anchoJugador= juego.getAnchoJugador();
		int posXEnemigo= (int)this.enemigo.getPos().getX();
		int posYEnemigo=(int)this.enemigo.getPos().getY();
		if(posYEnemigo>700)this.enemigo.getPos().setLocation(posXEnemigo, -10);
		if(posXEnemigo > posJ.getX() ) {
			if(posXEnemigo+35 > (posJ.getX()+anchoJugador)) {
				this.enemigo.mover(0);
			}
			this.enemigo.mover(3);
		}
		else {
			if(posXEnemigo < posJ.getX()) {
				this.enemigo.mover(1);
				this.enemigo.mover(3);
			}
			else {
				this.enemigo.mover(3);
			}
		}
		
	}
}
