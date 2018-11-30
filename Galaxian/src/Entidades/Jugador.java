package Entidades;

import javax.swing.ImageIcon;

import Armas.Arma;
import Armas.ArmaBasicaJugador;
import Colisionadores.*;
import Disparos.Disparo;

public class Jugador extends Entidad {
	
	private Arma arma;
	private Escudo escudo;
	
	public Jugador(int x, int y) {
		super(10,x,y);
		
		this.vida=100;
		
		arma= new ArmaBasicaJugador(this);
		
		inicializarArregloImg();
		
		escudo=new EscudoNormal(this);
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/naveFinal1.png"));
		this.imagen[1]= new ImageIcon(this.getClass().getResource("/img/naveEscudo.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp;
		disp = arma.generarDisparo((int)pos.getX()+(this.getGrafico().getWidth()/2 -1), (int)pos.getY()-12);	
		return disp;
	}
	
	public void sumarVida(int v) {
		this.vida+=v;
	}
	
	public void colisionar(Entidad e) {
		ColisionadorJugador col= new ColisionadorJugador(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
	
	 public void actualizar(){
	        arma.actualizar();
	 }
	 
	 public void setArma(Arma a) {
		 this.arma=a;
	 }
	
	 public void setEscudo(Escudo e) {
		 this.escudo=e;
	 }
	 
	 public void setVida(int i) {
		 this.vida=i;
	 }

	 public void recibirDañoKamikaze(int damage) {
		 escudo.recibirDañoKamikaze(damage);
	 }

	 public void quitarVida(int damage) {
		 escudo.recibirDaño(damage);
	 }
}
