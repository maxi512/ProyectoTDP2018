package Entidades;

import Inteligencias.*;
import Colisionadores.*;
import javax.swing.ImageIcon;

public class Disparo extends Entidad{
	int damage;
	
	public Disparo(int velocidad,int x,int y) {
		super(velocidad,x,y);
		
		damage=50;
		
		vida= 10;
		
		this.setInteligencia(new InteligenciaDisparo(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/disparoBasico.png"));
	}
	
	public void mover() {
		this.inteligencia.mover();
	}
	
	//METODOS PROVISORIOS
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
	
	public void golpearEntidad(Entidad e) {
		e.quitarVida(damage);
		this.vida=-1;
	}
	
	public int getDamage() {
		return damage;
	}
	
}
