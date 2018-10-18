package Entidades;


import javax.swing.ImageIcon;
import Colisionadores.*;

public class Jugador extends Entidad {
	private static final int SHOOT_COOLDOWN_UPDATE_TIME = 10;
	private long timeUntilShootingAvailable = 0;
	
	public Jugador(int x, int y) {
		super(10,x,y);
		
		this.vida=200;
		
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/naveEscudo.png"));
	}
	
	public Disparo crearDisparo() {
		Disparo disp;
		if(timeUntilShootingAvailable <=0) {
			disp= new DisparoJugador(5,(int)pos.getX()+(this.getGrafico().getWidth()/2 -1),(int)pos.getY()-12);
			timeUntilShootingAvailable= SHOOT_COOLDOWN_UPDATE_TIME;
		}
		else {
			disp= null;
		}
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
	
	 public void Update(){
	        timeUntilShootingAvailable = timeUntilShootingAvailable - 1;
	    }
	
}
