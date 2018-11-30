package Disparos;

import javax.swing.ImageIcon;

import Inteligencias.*;
import Colisionadores.*;
import Entidades.*;


public class DisparoEnemigo extends Disparo {
	
	public DisparoEnemigo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		this.damage=15;
				
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
	
	public void colisionar(Entidad e) {
		Colision col= new ColisionadorDisparoEnemigo(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarDisparoEnemigo(this);
	}
	
	public void golpearJugador(Jugador j) {
		j.quitarVida(damage);
		this.vida=-1;
	}
	
	public void golpearObstaculoEnemigoYJugador(Obstaculo o) {
		o.quitarVida(damage);
		vida=-1;
	}

	public void golpearObstaculoJugador(Obstaculo o) {
	}

	@Override
	public void golpearEnemigo(Enemigo enem) {
		// TODO Auto-generated method stub
		
	}
	
}
