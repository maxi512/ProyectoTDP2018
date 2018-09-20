package Principal;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.awt.event.KeyEvent;

import Principal.GUI;

public class Juego {
	private Mapa mapa;
	private Jugador jugador;
 	private LinkedList<Entidad> entidades;
 	private LinkedList<Entidad> entidadesAEliminar;
 	//ATRIBUTO PROVISORIO
 	private LinkedList<Enemigo> enem;
	
	public Juego(GUI gui) {	
		this.mapa=new MapaBase();	//Pongo Mapa base para probar
		entidades = new LinkedList<Entidad>();
		entidadesAEliminar = new LinkedList<Entidad>();
		
		this.jugador=new Jugador(165,490);
		gui.add(jugador.getGrafico());
		
		enem= mapa.getEnemigos();
		
		for(Enemigo e: enem) {
			entidades.add(e);
		}
		for (Enemigo e: enem) {
			gui.add(e.getGrafico());
		}
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
		
		for(Enemigo e: enem){
			movimientos=e.getCantMovimientos();
			
			if(movimientos>=0 && movimientos<30) {
				dir= 1;
				movimientos++;
				e.ajustarMovimientos(movimientos);
			}
			else {
				if(movimientos>=30 && movimientos< 60) {
					dir=0;
					movimientos++;
					e.ajustarMovimientos(movimientos);
					if(movimientos==60) {
						e.ajustarMovimientos(0);
					}
				}
				
			}
			
			e.mover(dir);
		}
	}
	
	public LinkedList<Entidad> getListaEntidades(){
		return entidades;
	}
	
	public LinkedList<Entidad> getListaEntidadesAEliminar(){
		return entidadesAEliminar;
	}
	
	public void eliminarEntidades() {
		try {
			if(!(entidades.isEmpty()&&entidadesAEliminar.isEmpty())) {
				for(Entidad e: entidadesAEliminar) {
					entidades.remove(e);
					enem.remove(e); //PROVISORIO
					e.destruir();
					entidadesAEliminar.remove(e);
				}
			}
		}
		catch(NoSuchElementException e) {
			
		}
	}
	
	//METODO PROVISORIO PARA TERCER SPRINT
	public void eliminarEnemigo() {
		if(!(enem.isEmpty()))entidadesAEliminar.add(enem.getLast());
	}
}
