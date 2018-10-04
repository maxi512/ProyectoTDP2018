package Entidades;

import Principal.*;
import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorEnemigo;
import Inteligencias.*;

public class EnemigoKamikaze extends Enemigo{
	
	public EnemigoKamikaze(int velocidad,int x, int y, Juego j) {
		super(velocidad,x,y);
		
		this.vida= 200;
		
		this.juego= j;
		
		inicializarArregloImg();
		this.setPuntaje(300);
		this.setInteligencia(new InteligenciaKamikaze(this,j));
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

 