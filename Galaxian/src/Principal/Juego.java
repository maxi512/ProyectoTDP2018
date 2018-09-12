package Principal;

import java.util.LinkedList;
import java.awt.*;
import java.awt.event.KeyEvent;

import Principal.GUI;

public class Juego {
	private Mapa mapa;
	private Jugador jugador;
	private LinkedList<Entidad> entidades;
	
	public Juego(GUI gui) {
		this.mapa=new Mapa();
		this.jugador=new Jugador(165,490);
		entidades = new LinkedList<Entidad>();
		/**for (int i=0;i<mapa.enemigos.length;i++) {
			entidades.add(mapa.enemigos[i]);
		}
		for (int i=0;i<mapa.enemigos.length;i++) {
			entidades.add(mapa.obstaculos[i]);
		}*/
		gui.add(jugador.getGrafico());
	}
	

	public void mover(int dir) {
		int direccion=-1;
		switch(dir) {
		case KeyEvent.VK_LEFT:
			direccion=0;
			break;
		case KeyEvent.VK_RIGHT:
			direccion=1;
			break;
		}
		jugador.mover(direccion);
	}
}
