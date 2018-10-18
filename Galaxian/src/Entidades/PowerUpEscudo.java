package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Inteligencias.InteligenciaPowerUp;
import Principal.Juego;

public class PowerUpEscudo extends PowerUp {

	public PowerUpEscudo(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y, j);
		this.setInteligencia(new InteligenciaPowerUp(this));
		inicializarArregloImg();
	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/escudo.png"));
	}
	
	public void afectar() {
		this.juego.getJugador().activarEscudo();
	}

	public void serColisionado(Colision col) {
		col.afectarPowerUp(this);
	}

	public void colisionar(Entidad e) {
		// TODO Auto-generated method stub
		
	}
	
}
