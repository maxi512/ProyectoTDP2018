package Inteligencias;

import java.util.Random;

import Entidades.Enemigo;

public class InteligenciaNormalCambiaMareado extends InteligenciaEnemigoSinArma {

	private Random r;
	
	public InteligenciaNormalCambiaMareado(Enemigo enem) {
		super(enem);
		r=new Random();
	}
	
	public void mover() {
		super.mover();
		if(r.nextInt(60)==5) {
			this.enemigo.setInteligencia(new InteligenciaMareado(this.enemigo));
		}
	}
	
}
