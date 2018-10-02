package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.*;

public class OtroEnemigo extends Enemigo{
	public OtroEnemigo(int velocidad,int x, int y) {
		super(velocidad,x,y);
		
		this.vida= 200;
		
		inicializarArregloImg();
		this.setPuntaje(300);
		this.setInteligencia(new InteligenciaEnemigo(this));
	}
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/Webp.net-gifmaker (3).gif"));
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
}

 