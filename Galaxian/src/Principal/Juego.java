package Principal;

import java.util.LinkedList;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Disparos.Disparo;

import java.awt.Rectangle;

import Principal.GUI;
import Entidades.*;
import java.awt.*;

public class Juego {
	//ATRIBUTOS
	private GUI miGui;
	private Mapa mapa;
	
	
	private Jugador jugador;
	
 	private LinkedList<Entidad> entidades;
 	private LinkedList<Entidad> entidadesAEliminar;
 	private LinkedList<Entidad> entidadesParaAgregar;
 	private LinkedList<Disparo> disparos;
 	private LinkedList<Disparo> disparosParaAgregar;
 	
 	private int puntajeTotal;
 	
 	private boolean moverDerecha,cambioDireccion;
 	private boolean terminarJuego=false;
 	
 	//CONSTRUCTOR
	public Juego(GUI gui) {	
		mapa = new MapaNivel1(this);
		
		miGui = gui;
		
		entidadesAEliminar = new LinkedList<Entidad>();
		entidadesParaAgregar= new LinkedList<Entidad>();
		disparos= new LinkedList<Disparo>();
		disparosParaAgregar= new LinkedList<Disparo>();
		
		this.jugador=new Jugador(265,610);
		miGui.add(jugador.getGrafico());
		
		armarNivel();

		cambioDireccion= false;
		moverDerecha=true;
	}
	
	private void armarNivel() {
		LinkedList<Entidad> aux= new LinkedList<Entidad>();
		aux.addLast(jugador);
		for(Enemigo e: mapa.getEnemigos()) {
			aux.addLast(e);
			miGui.add(e.getGrafico());
		}
		
		for(Entidad o: mapa.getObstaculos()) {
			aux.addLast(o);
			miGui.add(o.getGrafico());
		}
		
		entidades=aux;
	}
	
	public int getAnchoGui() {
		return miGui.getWidth();
	}

	public void mover() {
		synchronized(entidades) {
			for(int i=1;i<entidades.size();i++) {
				entidades.get(i).mover();
			}
		}
		if(cambioDireccion) {
			moverDerecha=false;
		}
		else {
			moverDerecha= true;
		}
	}
		
	public Jugador getJugador() {
		return jugador;
	}
	
	public void detectarColisiones() {
		synchronized(entidades) {
			for(int i=0;i<entidades.size();i++) {
				if(entidades.get(i)!=null) {
					Rectangle r1 = entidades.get(i).getRectangle();
					for(int j=i+1;j<entidades.size();j++) {
						if(entidades.get(j)!=null) {
							Rectangle r2= entidades.get(j).getRectangle();
			 				if(r1.intersects(r2)){
								entidades.get(i).colisionar(entidades.get(j));
							}
						}
					}
				}
			}
		}
	}
	
	public void eliminarEntidades() {
		quitarEntidades();
		
		LinkedList<Entidad> entidadesEliminar= entidadesAEliminar;
		entidadesAEliminar= new LinkedList<Entidad>();
		
		synchronized(entidades) {
			if(entidades.size()>0){
				for(Entidad e: entidadesEliminar) {
					entidades.remove(e);
					e.destruir();
					this.destruir(e);
					
				}
			}
		}
		
	}
	
	private void destruir(Entidad d) {
		miGui.remove(d.getGrafico());
		miGui.repaint();
	}

	private void quitarEntidades() {
		@SuppressWarnings("unchecked")
		LinkedList<Entidad> lista= (LinkedList<Entidad>) entidades.clone();
		
		for(Entidad e: lista) {
			if(e.getVida()<=0) {
				entidadesAEliminar.add(e);
				puntajeTotal+= e.getPuntaje();
			}
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
		JLabel vida = miGui.getLabelVida();
		vida.setText("VIDA: "+jugador.getVida());
		
	}
	
	public Point getPosJugador() {
		return jugador.getPos();
	}
	
	public int getAnchoJugador() {
		return jugador.getGrafico().getWidth();
	}
	
	public synchronized void addEntidad(Entidad e) {
		entidadesParaAgregar.add(e);
	}
	
	public void agregarEntidades() {
		LinkedList<Entidad> aux= entidadesParaAgregar;
		entidadesParaAgregar= new LinkedList<Entidad>();
		
		synchronized(entidades) {
			for(Entidad e : aux) {
				entidades.addLast(e);
				miGui.add(e.getGrafico());
			}
		}
	}
	
	public void moverDisparo() {
		synchronized(disparos) {
			for(Disparo d : disparos) {
				d.mover();
			}
		}
	}

	public void eliminarDisparos() {
		Disparo d;
		synchronized(disparos) {
			for(int i=0;i<disparos.size();i++) {
				d= disparos.get(i);
				if(d.getVida()<=0) {
					entidadesAEliminar.add(d);
					disparos.remove(d);
				}
			}
		}
	}

	public void moverJugador() {
		if(miGui.getRight().isKeyDown())
           jugador.mover(1);

        if(miGui.getLeft().isKeyDown())
        	jugador.mover(0);

        if(miGui.getSpace().isKeyDown()) {
        	Disparo d= jugador.crearDisparo();
    		if(d!=null) {
    			this.addDisparo(d);
    		}
        }
        	
	}
	
	public void Actualizar() {
		jugador.actualizar();
	}
		
	public void setCambiarDireccion(boolean dir) {
		cambioDireccion= dir;
	}
	
	public boolean moverDerecha() {
		return moverDerecha;
	}
	
	public boolean cambioDireccion() {
		return cambioDireccion;
	}
	
	public void accionarDisparos() {
		synchronized(entidades) {
			for(Entidad e: entidades) {
				e.disparar();
			}
		}
	}

	public void addDisparo(Disparo d) {
		disparosParaAgregar.addLast(d);
	}
	
	public synchronized void agregarDisparos() {	
		LinkedList<Disparo> disparoAux= disparosParaAgregar;
		disparosParaAgregar= new LinkedList<Disparo>();
		
		synchronized(disparos) {
			for(Disparo d : disparoAux) {
				entidadesParaAgregar.addLast(d);
				disparos.addLast(d);
				miGui.add(d.getGrafico());
			}
		}
	}
	
	public boolean jugadorVivo() {
		return jugador.getVida()>0;
	}

	public boolean hayEnemigos() {
		boolean toReturn=false;
		if(entidades.size()>1) {
			toReturn=true;
		}
		return toReturn;
	}
		
	public void cambiarNivel() {
		if(mapa.getSiguienteNivel()!=null) {
			mapa= mapa.getSiguienteNivel();
			armarNivel();
		}
		else {
			terminarJuego=true;			
		}
	}

	public boolean continuarJuego() {
		return (jugador.getVida()>0 && !terminarJuego); 
	}
	
	public void terminarJuego() {		
		if(jugador.getVida()>0) {
			miGui.terminar(0);
		}
		else {
			miGui.terminar(1);
		}
	}
	
	public LinkedList<Entidad> getListaEntidades(){
		return entidades;
	}	

}
