package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorObstaculo;

public class ObstaculoBasico extends Obstaculo{
	
	public ObstaculoBasico(int x, int y) {
		super(x,y);
		inicializarArregloImg();
		
		this.vida=400;
		this.puntaje=50;
		this.vidaInicial=vida;
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/obstaculo.png"));
	}
	
	//METODOS PROVISORIOS
	public void serColisionado(Colision col) {
		col.afectarObstaculo(this);
}

	public void colisionar(Entidad e) {
		ColisionadorObstaculo col= new ColisionadorObstaculo(this);
		e.serColisionado(col);
	}
	
}
