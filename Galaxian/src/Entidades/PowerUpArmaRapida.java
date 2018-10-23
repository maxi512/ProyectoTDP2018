package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorPowerUp;
import Inteligencias.InteligenciaPowerUp;
import Principal.Juego;

public class PowerUpArmaRapida extends PowerUp {

	public PowerUpArmaRapida(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y, j);
		this.vida=10;                 
		this.setInteligencia(new InteligenciaPowerUp(this));
		inicializarArregloImg();
	}
	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/armaMejorada2.png"));
	}
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
			this.destruir();
		}
	}
	public void afectar() {
		Jugador j= this.juego.getJugador();
		j.setArma(new ArmaRapida(j));
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
