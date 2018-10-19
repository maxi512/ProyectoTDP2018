package Entidades;


import java.util.Random;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.*;

public class EnemigoKamikaze extends Enemigo{
	
	private int damage;
	private boolean cambieInteligencia;
	
	public EnemigoKamikaze(int velocidad,int x, int y) {
		super(velocidad,x,y);
		
		this.vida= 200;
		damage=80;
		this.cambieInteligencia = false;
		
		inicializarArregloImg();
		this.setPuntaje(300);
		this.setInteligencia(new InteligenciaEnemigoConArma(this));
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (3).gif"));
	}
	
	public void mover() {
		Random r = new Random();
		if(!cambieInteligencia&&r.nextInt(60)==5) {
		this.setInteligencia(new InteligenciaKamikaze(this,this.juego));
			cambieInteligencia=true;
		}
		this.inteligencia.mover();
		
	}
	
	//METODOS PROVISORIOS
	public void serColisionado(Colision col) {
		col.afectarEnemigo(this);
	}
	
	public void colisionar(Entidad e) {
		ColisionadorEnemigo col= new ColisionadorEnemigo(this);
		e.serColisionado(col);
	}
	
	public void golpearJugador(Jugador j) {
		j.quitarVida(damage);
		this.vida=-1;
	}
	
	public void golpearObstaculo(Obstaculo o) {
		o.quitarVida(this.damage);
		this.vida=-1;
	}
}

 