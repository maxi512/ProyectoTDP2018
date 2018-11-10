package Inteligencias;

import java.util.Random;

import Entidades.Enemigo;

public class InteligenciaNormalCambiaKamikaze extends InteligenciaEnemigo {
	
	private Random r;
	
	public InteligenciaNormalCambiaKamikaze(Enemigo e) {
		this.enemigo=e;
		this.r=new Random();
	}
	
	public void mover() {
		super.mover();
		if(r.nextInt(60)==10) {
			this.enemigo.setInteligencia(new InteligenciaKamikaze(this.enemigo, this.enemigo.getJuego()));
		}
	}
	
}
