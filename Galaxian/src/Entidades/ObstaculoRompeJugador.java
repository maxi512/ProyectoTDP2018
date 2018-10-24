package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorObstaculoRompeJugador;

public class ObstaculoRompeJugador extends Obstaculo{
	
	public ObstaculoRompeJugador(int x, int y) {
		super(x,y);
		inicializarArregloImg();
		
		this.vida=400;
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/obstaculo.png"));
	}
	
	//METODOS PROVISORIOS
	public void serColisionado(Colision col) {
		col.afectarObstaculo(this);
}

	public void colisionar(Entidad e) {
		ColisionadorObstaculoRompeJugador col= new ColisionadorObstaculoRompeJugador(this);
		e.serColisionado(col);
	}
	
}
