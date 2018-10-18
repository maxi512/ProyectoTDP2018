package Entidades;

import javax.swing.ImageIcon;

import Inteligencias.*;
import Colisionadores.*;

public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		this.damage=30;
				
		this.setInteligencia(new InteligenciaDisparoEnemigo(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/disparoBasico.png"));
	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	
	//METODOS PROVISORIOS
	public void colisionar(Entidad e) {
		Colision col= new ColisionadorDisparo(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarDisparo(this);
	}
	
	public void golpearJugador(Jugador j) {
		j.quitarVida(damage);
		this.vida=-1;
	}
}
