package Inteligencias;

import java.util.Random;
//import Inteligencias.*;

import Armas.Arma;
import Disparos.Disparo;
import Entidades.Enemigo;

public class InteligenciaEnemigoPierdeArma extends InteligenciaEnemigo {
	
	private Random r;
	
	public InteligenciaEnemigoPierdeArma(Enemigo enem){
		this.enemigo=enem;
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
			enemigo.setInteligencia(new InteligenciaKamikaze(this.enemigo, this.enemigo.getJuego()));
			this.enemigo.setImagenActual(1);
		}
		
	}
}
