package Inteligencias;

import Entidades.Enemigo;

public class InteligenciaEnemigoArmaCambiaMareado extends InteligenciaEnemigoConArma {

	
	public InteligenciaEnemigoArmaCambiaMareado(Enemigo enem) {
		super(enem);
	}
	
	public void mover() {
		super.mover();
		if(this.enemigo.getVida()<=30) {
			this.enemigo.setInteligencia(new InteligenciaMareado(this.enemigo));
		}
	}

}
