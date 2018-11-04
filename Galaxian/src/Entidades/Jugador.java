package Entidades;


import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Colisionadores.*;

public class Jugador extends Entidad {
	
	private Arma arma;
	private boolean escudo;
	
	public Jugador(int x, int y) {
		super(10,x,y);
		
		this.vida=100;
		
		arma= new ArmaBasicaJugador(this);
		
		inicializarArregloImg();
		
		escudo=false;
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/playerShip1_blue.png"));
		this.imagen[1]= new ImageIcon(this.getClass().getResource("/img/naveEscudo.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp;
		disp = arma.generarDisparo();
		return disp;
	}
	
	public void sumarVida(int v) {
		this.vida+=v;
	}
	
	
	public void activarEscudo() {
		this.cambiarGrafico(1);
		this.imagenActual=1;
		escudo=true;
	}
	
	public void desactivarEscudo() {
		this.grafico= new JLabel(this.imagen[0]);
		escudo=false;
	}
	
	
	//METODOS PROVISORIOS
	public void colisionar(Entidad e) {
		ColisionadorJugador col= new ColisionadorJugador(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
	
	 public void Update(){
		 arma.Update();
	 }
	 
	 public void setArma(Arma a) {
		 this.arma=a;
	 }
	
}
