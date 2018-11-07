package PowerUps;

import javax.swing.ImageIcon;
import Colisionadores.Colision;
import Entidades.Entidad;
import Inteligencias.InteligenciaPowerUp;

public class PowerUpVida extends PowerUp {

	public PowerUpVida(int velocidad, int x, int y) {
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
		this.imagen[0]= new ImageIcon(this.getClass().getResource("/img/vida.png"));
	}
	
	public void afectar() {
		this.juego.getJugador().sumarVida(50);
		this.vida=0;
		
	}

	public void serColisionado(Colision col) {
		col.afectarPowerUp(this);
	}

	public void colisionar(Entidad e) {
		// TODO Auto-generated method stub
		
	}

}
