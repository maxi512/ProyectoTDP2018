 package Entidades;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorPowerUp;
import Inteligencias.InteligenciaPowerUp;
import Principal.HiloDetieneTiempo;
import Principal.Juego;

public class PowerUpTiempo extends PowerUp {

	public PowerUpTiempo(int velocidad, int x, int y, Juego j) {
		super(velocidad, x, y, j);
		inicializarArregloImg();
		this.setInteligencia(new InteligenciaPowerUp(this));
		this.vida= 10;
	}
	
	public void mover() {
		this.inteligencia.mover();
		if(this.pos.getY()>710) {
			this.vida=-1;
		}
	}

	private void inicializarArregloImg() {
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/reloj.png"));
	}
	@Override
	public void afectar() {
		HiloDetieneTiempo hilo = new HiloDetieneTiempo(this.juego);
		hilo.start();	
		this.vida=-1;
	}

	@Override
	public void serColisionado(Colision col) {
		col.afectarPowerUp(this);
	}

	@Override
	public void colisionar(Entidad e) {
		ColisionadorPowerUp col= new ColisionadorPowerUp(this);
		e.serColisionado(col);
		
	}
	
	
}
