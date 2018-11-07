package Inteligencias;

import java.util.Random;

import Armas.Arma;
import Disparos.Disparo;
import Entidades.Enemigo;

public class InteligenciaEnemigoBasicoPierdeArma extends InteligenciaEnemigoConArma {

	private Random r;
	
	public InteligenciaEnemigoBasicoPierdeArma(Enemigo enem){
		super(enem);
		r= new Random();

	}
	
	public void disparar() {
		if (enemigo.getVida()>enemigo.getVidaInicial()*0.2) {
			if(r.nextInt(10)==5) {
				Arma arma= enemigo.getArma();
				if(arma!=null) {
					Disparo d= arma.generarDisparo();
					d.getPos().setLocation((int)enemigo.getPos().getX()+(enemigo.getGrafico().getWidth()/2 -1), (int)enemigo.getPos().getY()+30);
					enemigo.getJuego().addDisparo(d);
				}
			}
		}
		else {
			enemigo.setInteligencia(new InteligenciaEnemigoSinArma(this.enemigo));
			this.enemigo.setImagenActual(1);
		}
		
	}
}
