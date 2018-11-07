 package PowerUps;

import javax.swing.ImageIcon;

import Colisionadores.Colision;
import Colisionadores.ColisionadorPowerUp;
import Entidades.Entidad;
import Inteligencias.InteligenciaPowerUp;
import Principal.HiloDetieneTiempo;

public class PowerUpTiempo extends PowerUp {

	public PowerUpTiempo(int velocidad, int x, int y) {
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
