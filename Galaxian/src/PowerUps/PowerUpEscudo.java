package PowerUps;

import javax.swing.ImageIcon;

import Colisionadores.*;
import Entidades.*;
import Inteligencias.InteligenciaPowerUp;

public class PowerUpEscudo extends PowerUp {

	public PowerUpEscudo(int velocidad, int x, int y) {
		super(velocidad, x, y);
		this.setInteligencia(new InteligenciaPowerUp(this));
		inicializarArregloImg();
	}
	
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/escudo.png"));
	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}
	
	public void afectar() {
		Jugador j = this.juego.getJugador();
		j.setEscudo(new EscudoKamikaze(j));
		this.vida=0;
	}

	public void serColisionado(Colision col) {
		col.afectarPowerUp(this);
	}

	public void colisionar(Entidad e) {
		ColisionadorPowerUp col= new ColisionadorPowerUp(this);
		e.serColisionado(col);
	}
	
}
