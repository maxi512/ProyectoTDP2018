package PowerUps;

import javax.swing.ImageIcon;

import Armas.ArmaMejorada;
import Colisionadores.Colision;
import Colisionadores.ColisionadorPowerUp;
import Inteligencias.InteligenciaPowerUp;
import Entidades.*;

public class PowerUpArmaMejorada extends PowerUp {
	public PowerUpArmaMejorada(int velocidad, int x, int y) {
		super(velocidad, x, y);
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
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/armaMejorada.png"));
	}
	
	public void afectar() {
		Jugador j= this.juego.getJugador();
		j.setArma(new ArmaMejorada(j));
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
