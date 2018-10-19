package Principal;

import java.util.LinkedList;


import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 	private LinkedList<Disparo> disparos;
 	private LinkedList<Disparo> disparosParaAgregar;
 	
 	private int puntajeTotal;
 	
 	private boolean moverDerecha,cambioDireccion;
	
 	//CONSTRUCTOR
	public Juego(GUI gui) {	
		this.mapa=new MapaBase(this);	//Pongo Mapa base para probar
		miGui = gui;
		
		entidades = new LinkedList<Entidad>();
		entidadesAEliminar = new LinkedList<Entidad>();
		disparos= new LinkedList<Disparo>();
		disparosParaAgregar= new LinkedList<Disparo>();
		
		this.jugador=new Jugador(265,610);
		miGui.add(jugador.getGrafico());
		entidades.add(jugador);
		
		LinkedList<Enemigo> enem= mapa.getEnemigos();
		
		for(Enemigo e: enem) {
			entidades.add(e);
			miGui.add(e.getGrafico());
		}
		
		for(Entidad o: mapa.getObstaculos()) {
			entidades.add(o);
			miGui.add(o.getGrafico());
		}
		
		cambioDireccion= false;
		moverDerecha=true;
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
		for(int i=0;i<entidades.size();i++) {
			if(entidades.get(i)!=null) {
				Rectangle r1 = entidades.get(i).getRectangle();
				for(int j=i+1;j<entidades.size();j++) {
					if(entidades.get(j).getGrafico()!=null) {
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
		}
	}
	
	public void eliminarEntidades() {
		Entidad elemento;
		synchronized(entidades) {
			synchronized(entidadesAEliminar) {
				if(!(entidades.isEmpty()&&entidadesAEliminar.isEmpty())){
					for(int i=0;i<entidadesAEliminar.size();i++) {
						elemento= entidadesAEliminar.get(i);
						entidades.remove(elemento);
						elemento.destruir();
						entidadesAEliminar.remove(elemento);
					}
				}
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
	
	public void addEntidad(Entidad e) {
		entidades.add(e);
	}
	
	//METODOS PROVISORIOS
	
	public void moverDisparo() {
		synchronized(disparos) {
			for(Disparo d : disparos) {
				d.mover();
			}
		}
	}

	public void eliminarDisparos() {
		synchronized(entidades) {
			synchronized(disparos) {
				for(int i=0;i<disparos.size();i++) {
					if(disparos.get(i).getVida()<=0) {
						entidades.remove(disparos.get(i));
						disparos.get(i).destruir();
						disparos.remove(i);
					}
				}
			}
		}
	}

	
	////METODOS PROVISORIOS 2
	public void moverJugador() {
		if(miGui.right.isKeyDown())
           jugador.mover(1);

        if(miGui.left.isKeyDown())
        	jugador.mover(0);

        if(miGui.space.isKeyDown()) {
        	Disparo d= jugador.crearDisparo();
    		if(d!=null) {
    			this.addDisparo(d);
    		}
        }
        	
	}
	
	public void Update() {
		jugador.Update();
	}
	
	public void manage() {
		if(entidades.size()== 1&& jugador.getVida()>0) {
			PrimerBoss boss=null;
			boss = PrimerBoss.getPrimerBoss(10,200,200);
			if(boss!=null) {
				boss.setJuego(this);
				entidades.add(boss);
				miGui.add(boss.getGrafico());
			}
		}
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
		synchronized(disparosParaAgregar) {
			disparosParaAgregar.addLast(d);
		}
	}
	
	public synchronized void agregarDisparos() {
		Disparo d;
		synchronized(entidades) {
			synchronized(disparos) {
				if(disparosParaAgregar.size()>0) {			
					for(int i=0;i<disparosParaAgregar.size();i++) {
						d= disparosParaAgregar.get(i);
						entidades.add(d);
						disparos.addLast(d);
						miGui.add(d.getGrafico());
						disparosParaAgregar.remove(d); 
					}
				}
			}
		}
	}
	
	public boolean jugadorVivo() {
		return jugador.getVida()>0;
	}


	public void terminarJuego() {
		JLabel partidaTerminada= new JLabel("La partida termino",JLabel.CENTER);
		JPanel panel= new JPanel(new BorderLayout());
		panel.setBounds(0, 0, miGui.getWidth(), miGui.getHeight());
		panel.setBackground(Color.RED);  
		panel.add(partidaTerminada,BorderLayout.CENTER);
		
		//Destruyo el jugador
		entidades.get(0).destruir();
		entidades.removeFirst();
		//
		miGui.add(panel);
	}
	
	
	public LinkedList<Entidad>getListaEntidades(){
		return entidades;
	}
	
	public LinkedList<Disparo> getListaDisparos(){
		return disparos;
	}
	
}
