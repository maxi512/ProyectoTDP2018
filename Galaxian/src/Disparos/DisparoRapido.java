package Disparos;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorDisparo;
import Entidades.Enemigo;
import Entidades.Entidad;
import Entidades.Obstaculo;
import Inteligencias.InteligenciaDisparoJugador;

public class DisparoRapido extends Disparo {
	
	private int damage;
	
	public DisparoRapido(int velocidad, int x, int y) {
		super(velocidad, x, y);
		
		this.damage=10;
		
		this.setInteligencia(new InteligenciaDisparoJugador(this));
		inicializarArregloImg();
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
