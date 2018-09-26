package Principal;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Principal.GUI;

public class Juego {
	//ATRIBUTOS
	private GUI miGui;
	private Mapa mapa;
	private Jugador jugador;
 	private LinkedList<Entidad> entidades;
 	private LinkedList<Entidad> entidadesAEliminar;
 	private int puntajeTotal;
 	//ATRIBUTO PROVISORIO
 	private LinkedList<Enemigo> enem;
	
 	//CONSTRUCTOR
	public Juego(GUI gui) {	
		this.mapa=new MapaBase();	//Pongo Mapa base para probar
		entidades = new LinkedList<Entidad>();
		entidadesAEliminar = new LinkedList<Entidad>();
		
		this.jugador=new Jugador(265,790);
		gui.add(jugador.getGrafico());
		miGui = gui;
		
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
	
	public void detectarColisiones() {
		for(int i=0;i<entidades.size();i++) {
			Rectangle r1 = entidades.get(i).getRectangle();
			for(int j=i+1;j<entidades.size();j++) {
				Rectangle r2= entidades.get(j).getRectangle();
				if(r1.intersects(r2)){
					System.out.println("Colisionaron");
				}
			}
		}
	}
	
	public void detectarColisionesAux() {
		for(int i=0;i<entidades.size();i++) {
			int x1=entidades.get(i).getGrafico().getX();
			int y1=entidades.get(i).getGrafico().getY();
			int w1=entidades.get(i).getGrafico().getWidth();
			int h1=entidades.get(i).getGrafico().getHeight();
			for(int j=i+1;j<entidades.size();j++) {
				int x2=entidades.get(j).getGrafico().getX();
				int y2=entidades.get(j).getGrafico().getY();
				int w2=entidades.get(j).getGrafico().getWidth();
				int h2=entidades.get(j).getGrafico().getHeight();
				
				boolean intersectan = (x1>=x2-w1)&&(x1<=x2+w2)&&(y1>=y2-h1)&&(y1<=y2+h2);
				if(intersectan){
					System.out.println("Colisionaron");
				}
			}
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
					puntajeTotal+=e.getPuntaje();
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
	
	public int getPuntajeTotal() {
		return puntajeTotal;
	}
	
	public void actualizarLabels() {
		int aux = puntajeTotal;
		
		JLabel[] arr =miGui.getLabelPuntaje();
		
		for(int i=arr.length-1;i>=0&&aux!=0;i--) {
			int a= aux%10;
			switch(a) {
			case 0:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/Sin título-3.png")));
				break;
			case 1:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero1.png")));
				break;
			case 2:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero2.png")));
				break;
			case 3:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero3.png")));
				break;
			case 4:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero4.png")));
				break;
			case 5:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero5.png")));
				break;
			case 6:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero6.png")));
				break;
			case 7:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero7png.png")));
				break;
			case 8:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero8.png")));
				break;
			case 9:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numero9.png")));
				break;
			}
			aux/=10;
		}
		
	}
	//METODO PROVISORIO PARA TERCER SPRINT
	public void eliminarEnemigo() {
		if(!(enem.isEmpty()))entidadesAEliminar.add(enem.getLast());
	}
}
