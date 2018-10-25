package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorDisparo;
import Inteligencias.InteligenciaDisparoJugador;

public class DisparoRapido extends Disparo {
	
	private int damage;
	
	public DisparoRapido(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
		this.damage=15;
	}
	
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/disparoChico.png"));
	}

	public void serColisionado(Colision col) {
		col.afectarDisparo(this);
	}

	public void colisionar(Entidad e) {
		ColisionadorDisparo col= new ColisionadorDisparo(this);
		e.serColisionado(col);
	}
	
	public void golpearEnemigo(Enemigo e) {
		e.quitarVida(damage);
		this.vida=-1;
	}
	public void golpearObstaculoEnemigoYJugador(Obstaculo o) {
		vida=0; 
		o.quitarVida(damage);
	}
	public void golpearObstaculoJugador(Obstaculo o) {
		vida=0;
		o.quitarVida(damage);
	}
	
}
