package Inteligencias;

import java.util.Random;

import Entidades.*;

public class InteligenciaEnemigoConArma extends InteligenciaEnemigo{
	private Random r;
	
	public InteligenciaEnemigoConArma(Enemigo enem) {
		this.enemigo=enem;
		r= new Random();
	}
	
	public void disparar() {
		if(r.nextInt(40)==5) {
			Arma arma= enemigo.getArma();
			if(arma!=null) {
				Disparo d= arma.generarDisparo();
				enemigo.getJuego().addDisparo(d);
			}
		}
	}
}
