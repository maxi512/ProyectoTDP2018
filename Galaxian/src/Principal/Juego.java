package Principal;

import java.util.LinkedList;
import java.awt.event.KeyEvent;

import Principal.GUI;

public class Juego {
	private Mapa mapa;
	private Jugador jugador;
 	private LinkedList<Entidad> entidades;
 	private Enemigo enem[];
	
	public Juego(GUI gui) {
		//Pongo Mapa base para probar
		this.mapa=new MapaBase();
		entidades = new LinkedList<Entidad>();
		
		this.jugador=new Jugador(165,490);
		gui.add(jugador.getGrafico());
		
		enem= mapa.getEnemigos();
		for (int i=0;i<enem.length;i++) {
			gui.add(enem[i].getGrafico());
		}
		
		/*for (int i=0;i<mapa.enemigos.length;i++) {
			entidades.add(mapa.obstaculos[i]);
		}*/
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

	public void mover() {
		int dir=-1;
		int movimientos;
		
		for(int i = 0; i < enem.length; i++){
			movimientos=enem[i].getCantMovimientos();
			
			if(movimientos>=0 && movimientos<30) {
				dir= 1;
				movimientos++;
				enem[i].ajustarMovimientos(movimientos);
			}
			else {
				if(movimientos>=30 && movimientos< 60) {
					dir=0;
					movimientos++;
					enem[i].ajustarMovimientos(movimientos);
					if(movimientos==60) {
						enem[i].ajustarMovimientos(0);
					}
				}
				
			}
			
			enem[i].mover(dir);
		}
	}
	}
