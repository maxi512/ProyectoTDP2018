package Principal;

import java.util.LinkedList;
import java.util.NoSuchElementException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import Principal.GUI;
import Entidades.*;

public class Juego {
	//ATRIBUTOS
	private GUI miGui;
	private Mapa mapa;
	private Jugador jugador;
 	private LinkedList<Entidad> entidades;
 	private LinkedList<Entidad> entidadesAEliminar;
 	private LinkedList<Entidad> disparos;
 	private int puntajeTotal;
	
 	//CONSTRUCTOR
	public Juego(GUI gui) {	
		this.mapa=new MapaBase();	//Pongo Mapa base para probar
		miGui = gui;
		entidades = new LinkedList<Entidad>();
		entidadesAEliminar = new LinkedList<Entidad>();
		
		disparos= new LinkedList<Entidad>();
		
		this.jugador=new Jugador(265,610);
		miGui.add(jugador.getGrafico());
		entidades.add(jugador);
		
		
		
		LinkedList<Enemigo> enem= mapa.getEnemigos();
		
		for(Enemigo e: enem) {
			entidades.add(e);
			miGui.add(e.getGrafico());
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
		for(int i=1;i<entidades.size();i++) {
			entidades.get(i).mover();
		}
	}
	
	public void detectarColisiones() {
		for(int i=0;i<entidades.size();i++) {
			Rectangle r1 = entidades.get(i).getRectangle();
			for(int j=i+1;j<entidades.size();j++) {
				Rectangle r2= entidades.get(j).getRectangle();
				if(r1.intersects(r2)){
					entidades.get(i).colisionar(entidades.get(j));
					if(entidades.get(i).getVida()<=0) {
						entidadesAEliminar.add(entidades.get(i));
						puntajeTotal+= entidades.get(i).getPuntaje();
						
					}
					if(entidades.get(j).getVida()<=0) {
						entidadesAEliminar.add(entidades.get(j));
						puntajeTotal+= entidades.get(j).getPuntaje();
					}
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
			Entidad elemento;
			if(!(entidades.isEmpty()&&entidadesAEliminar.isEmpty())){
				for(int i=0;i<entidadesAEliminar.size();i++) {
					elemento= entidadesAEliminar.get(i);
					entidades.remove(elemento);
					elemento.destruir();
					entidadesAEliminar.remove(elemento);
				}
			}
		}
		catch(NoSuchElementException e) {
			System.out.println("eliminarEntidades >> No hay mas entidades para eliminar");
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
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/Sin título-3.png")));
				break;
			case 1:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero1.png")));
				break;
			case 2:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero2.png")));
				break;
			case 3:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero3.png")));
				break;
			case 4:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero4.png")));
				break;
			case 5:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero5.png")));
				break;
			case 6:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero6.png")));
				break;
			case 7:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero7png.png")));
				break;
			case 8:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero8.png")));
				break;
			case 9:
				arr[i].setIcon(new ImageIcon(this.getClass().getResource("/img/numeros/numero9.png")));
				break;
			}
			aux/=10;
		}
		
	}
	
	//METODO PROVISORIO PARA TERCER SPRINT   BORARR!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public void eliminarEnemigo() {
		int cantidad_entidades= entidades.size();
		if(cantidad_entidades>1) {
			entidadesAEliminar.add(entidades.getLast());
			puntajeTotal+= entidades.getLast().getPuntaje();
		}
	}
	
	//METODOS PROVISORIOS
	public void generarDisparo() {
		Disparo d= jugador.crearDisparo();
		miGui.add(d.getGrafico());
		entidades.add(d);
		disparos.add(d);
	}
	
	public LinkedList<Entidad> getListaDisparos(){
		return disparos;
	}
	
	public void moverDisparo() {
		for(int i=0;i<disparos.size();i++) {
			disparos.get(i).mover();
		}
	}

	public void eliminarDisparos() {
		for(int i=0;i<disparos.size();i++) {
			if(disparos.get(i).getVida()<=0) {
				disparos.get(i).destruir();
				disparos.remove(i);
			}
		}
	}
}
