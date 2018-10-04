package Entidades;

import javax.swing.ImageIcon;
import Colisionadores.*;
import java.awt.*;
public class Jugador extends Entidad {
	
	public Jugador(int x, int y) {
		super(12,x,y);
		this.vida=200;
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/naveFinal1.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp= new Disparo(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 -1),(int)pos.getY()-12);
		return disp;
	}
	
	
	//METODOS PROVISORIOS
	public void colisionar(Entidad e) {
		ColisionadorJugador col= new ColisionadorJugador(this);
		e.serColisionado(col);
	}
	
	public void serColisionado(Colision col) {
		col.afectarJugador(this);
	}
}
