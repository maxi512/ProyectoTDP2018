package Entidades;

import javax.swing.ImageIcon;
import Inteligencias.*;
import Colisionadores.*;

public class EnemigoBase extends Enemigo{
	protected Arma arma;
	
	public EnemigoBase(int velocidad,int x, int y) {
		super(velocidad,x,y);
		this.vida= 100;
		
		inicializarArregloImg();
		this.setPuntaje(7);
		this.setInteligencia(new InteligenciaEnemigoConArma(this));
		this.arma = new ArmaEnemigo();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (2).gif"));
	}

	public void mover() {
		this.inteligencia.mover();
	}

	public void disparar() {
		this.inteligencia.disparar();
	}
	
	//METODOS PROVISORIOS
	public void serColisionado(Colision col) {
		col.afectarEnemigo(this);
	}

	public void colisionar(Entidad e) {
		ColisionadorEnemigo col= new ColisionadorEnemigo(this);
		e.serColisionado(col);
	}
	
	public void golpearObstaculo(Obstaculo o) {
		o.quitarVida(20);
		this.vida=-1;
	}
	
	public Arma getArma() {
		return arma;
	}
	
}
