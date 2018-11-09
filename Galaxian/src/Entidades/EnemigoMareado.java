package Entidades;


import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.InteligenciaNormalCambiaMareado;

public class EnemigoMareado extends Enemigo{
	private int damage;
	
	public EnemigoMareado(int velocidad,int x, int y) {
		super(velocidad,x,y);
		
		this.vida= 200;
		this.vidaInicial=vida;
		damage=80;
		this.puntaje=200;
		
		inicializarArregloImg();	
		this.setInteligencia(new InteligenciaNormalCambiaMareado(this));
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/enemigoMareable.gif"));
	}
	
	public void mover() {
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
		j.recibirDañoKamikaze(damage);
		this.vida=-1;
	}
	
	public void golpearObstaculo(Obstaculo o) {
		o.quitarVida(this.damage);
		this.vida=-1;
	}
}

