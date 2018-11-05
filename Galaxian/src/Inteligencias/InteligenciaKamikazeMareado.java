package Inteligencias;

import java.util.Random;

import Entidades.Enemigo;

public class InteligenciaKamikazeMareado extends InteligenciaEnemigoSinArma {
	private Random r;
	
	public InteligenciaKamikazeMareado(Enemigo e) {
		super(e);
		this.r=new Random();
	}
	
	public void mover() {
		super.mover();
		if(r.nextInt(60)==5) {
			this.enemigo.setInteligencia(new InteligenciaKamikazeModificada(this.enemigo, this.enemigo.getJuego()));
		}
	}	
	
}
