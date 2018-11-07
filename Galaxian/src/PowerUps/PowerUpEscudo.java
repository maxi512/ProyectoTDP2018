package PowerUps;

import javax.swing.ImageIcon;

import Colisionadores.*;
import Entidades.Entidad;
import Entidades.EscudoKamikaze;
import Entidades.Jugador;
import Inteligencias.InteligenciaPowerUp;
import Principal.Juego;

public class PowerUpEscudo extends PowerUp {

	public PowerUpEscudo(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y, j);
		
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
			this.destruir();
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
