package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorDisparo;
import Inteligencias.InteligenciaDisparoJugador;

public class DisparoMisil extends Disparo {
	public DisparoMisil(int velocidad,int x,int y) {
		super(velocidad,x,y);
		this.damage= 100;
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/misil.gif"));
	}	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()<-5) {
			this.vida=-1;
		}
	}
	
	public void colisionar(Entidad e) {
		ColisionadorDisparo col= new ColisionadorDisparo(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarDisparo(this);
	}
	
	public void golpearEnemigo(Enemigo e) {
		e.quitarVida(damage);
		this.vida=-1;
	}
	
	public void golpearObstaculoEnemigoYJugador(Obstaculo o) {
		o.quitarVida(20);
	}
	public void golpearObstaculoJugador(Obstaculo o) {
		o.quitarVida(20);
	}
}
