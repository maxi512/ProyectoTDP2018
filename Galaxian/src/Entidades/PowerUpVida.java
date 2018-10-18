package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Inteligencias.InteligenciaDisparoEnemigo;
import Inteligencias.InteligenciaPowerUp;
import Principal.Juego;

public class PowerUpVida extends PowerUp {

	public PowerUpVida(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y, j);
		inicializarArregloImg();
		this.setInteligencia(new InteligenciaPowerUp(this));

	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/vida.png"));
	}
	
	public void afectar() {
		this.juego.getJugador().sumarVida(50);
	}

	public void serColisionado(Colision col) {
		col.afectarPowerUp(this);
	}

	public void colisionar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
