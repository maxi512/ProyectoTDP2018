package Entidades;

import java.util.Random;

import javax.swing.ImageIcon;
import Inteligencias.*;
import Colisionadores.*;

public class EnemigoBase extends Enemigo{
	
	private Random r;
	private Arma arma;
	
	public EnemigoBase(int velocidad,int x, int y) {
		super(velocidad,x,y);
		this.vida= 100;
		
		inicializarArregloImg();
		this.setPuntaje(7);
		this.setInteligencia(new InteligenciaEnemigo(this));
		r= new Random();
		arma = new ArmaEnemigo();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (2).gif"));
	}

	public void mover() {
		this.inteligencia.mover();
	}

	public void disparar() {
		if(r.nextInt(40)==5) {
			Disparo d = arma.generarDisparo();
			d.getPos().setLocation((int)pos.getX()+(this.getGrafico().getWidth()/2 -1), (int)pos.getY()+30);
			//DisparoEnemigo d =new DisparoEnemigo(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 -1),(int)pos.getY()+30);
			juego.addDisparo(d);
		}
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
}
